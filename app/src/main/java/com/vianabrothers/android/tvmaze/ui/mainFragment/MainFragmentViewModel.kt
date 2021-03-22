package com.vianabrothers.android.tvmaze.ui.mainFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.paging.ShowsPagingSource
import com.vianabrothers.android.tvmaze.repository.ShowsRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val showsRepository: ShowsRepository,
) : ViewModel() {

    private val _searchShows = MutableLiveData<List<Show>>()
    val searchShows: LiveData<List<Show>>
        get() = _searchShows


    fun searchShows(params: String) {
        viewModelScope.launch {
            try {
                val result = showsRepository.searchShows(params)
                _searchShows.postValue(result)
            } catch (ex: Exception) {
            }
        }
    }

    val flow = Pager(
        PagingConfig(pageSize = 250)
    ) {
        ShowsPagingSource(showsRepository)
    }.flow
        .cachedIn(viewModelScope)
}