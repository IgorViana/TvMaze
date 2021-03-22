package com.vianabrothers.android.tvmaze.ui.showDetailsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vianabrothers.android.tvmaze.model.Episode
import com.vianabrothers.android.tvmaze.repository.ShowsRepository
import kotlinx.coroutines.launch

class ShowDetailsViewModel(
    private val showsRepository: ShowsRepository,
) : ViewModel() {

    private val _showEpisodes = MutableLiveData<List<Episode>>()
    val showEpisodes: LiveData<List<Episode>>
        get() = _showEpisodes


    fun getShowEpisodes(showId: Long) {
        viewModelScope.launch {
            try {
                val result = showsRepository.getShowsEpisodes(showId)
                _showEpisodes.postValue(result)
            } catch (ex: Exception) {
            }
        }
    }
}