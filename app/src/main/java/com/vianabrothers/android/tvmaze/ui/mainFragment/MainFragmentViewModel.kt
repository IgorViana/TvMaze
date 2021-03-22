package com.vianabrothers.android.tvmaze.ui.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.vianabrothers.android.tvmaze.paging.ShowsPagingSource
import com.vianabrothers.android.tvmaze.repository.ShowsRepository

class MainFragmentViewModel(
    private val showsRepository: ShowsRepository,
) : ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 250)
    ) {
        ShowsPagingSource(showsRepository)
    }.flow
        .cachedIn(viewModelScope)
}