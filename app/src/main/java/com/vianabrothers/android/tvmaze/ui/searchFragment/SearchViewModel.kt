package com.vianabrothers.android.tvmaze.ui.searchFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vianabrothers.android.tvmaze.model.SearchShow
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.repository.ShowsRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    private val showsRepository: ShowsRepository,
) : ViewModel() {
    private val _searchShows = MutableLiveData<List<SearchShow>>()
    val searchShows: LiveData<List<SearchShow>>
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
}