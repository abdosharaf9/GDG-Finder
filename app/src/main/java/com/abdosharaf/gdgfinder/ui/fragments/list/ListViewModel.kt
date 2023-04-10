package com.abdosharaf.gdgfinder.ui.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdosharaf.gdgfinder.network.ChaptersResponse
import com.abdosharaf.gdgfinder.network.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val _chaptersResponse = MutableLiveData<ChaptersResponse>()
    val chaptersResponse: LiveData<ChaptersResponse>
        get() = _chaptersResponse

    init {
        getChapters()
    }

    private fun getChapters() {
        viewModelScope.launch {
            _chaptersResponse.value = apiService.getChapters()
        }
    }
}