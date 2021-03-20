package com.vianabrothers.android.tvmaze.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.repository.ShowsRepository

class ShowsPagingSource(val repository: ShowsRepository) : PagingSource<Int, Show>() {
    override fun getRefreshKey(state: PagingState<Int, Show>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Show> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 0
            val response = repository.getListShows(nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
        }
    }
}