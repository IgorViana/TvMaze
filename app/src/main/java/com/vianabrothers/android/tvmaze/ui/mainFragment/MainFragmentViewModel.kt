package com.vianabrothers.android.tvmaze.ui.mainFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vianabrothers.android.tvmaze.model.Show
import com.vianabrothers.android.tvmaze.repository.ShowsRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    val showsRepository: ShowsRepository,
) : ViewModel() {

    private val _shows = MutableLiveData<List<Show>>()
    val shows: LiveData<List<Show>>
        get() = _shows


    fun getListShows(page: Int) {
        viewModelScope.launch {
            try {
                val result = showsRepository.getListShows(page)
                _shows.postValue(result)
            } catch (ex: Exception) {
            }
        }

    }
}