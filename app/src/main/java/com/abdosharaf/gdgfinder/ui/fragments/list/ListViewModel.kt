package com.abdosharaf.gdgfinder.ui.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdosharaf.gdgfinder.network.ChapterData
import com.abdosharaf.gdgfinder.network.ChaptersResponse
import com.abdosharaf.gdgfinder.network.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val _chaptersResponse = MutableLiveData<ChaptersResponse>()

    private val _chaptersList = MutableLiveData<List<ChapterData>?>()
    val chaptersList: LiveData<List<ChapterData>?>
        get() = _chaptersList

    private val _filters = MutableLiveData<List<String>>()
    val filters: LiveData<List<String>>
        get() = _filters

    private val filter = Filter()

    init {
        getChapters()
    }

    private fun getChapters() {
        viewModelScope.launch {
            _chaptersResponse.value = apiService.getChapters()
            _chaptersList.value = _chaptersResponse.value?.data
            _filters.value = _chaptersResponse.value?.filters_?.region
        }
    }

    fun onFilterChanged(newFilter: String, checked: Boolean) {
        if(filter.updateFilter(newFilter, checked)) {
            updateList(newFilter)
        }
    }

    private fun updateList(filter: String) {
        val list = _chaptersResponse.value?.data?.filter {
            it.region == filter
        }
        _chaptersList.value = list
    }

    private inner class Filter {
        var currentFilter: String? = null
            private set

        fun updateFilter(newFilter: String, newState: Boolean): Boolean {
            return if(newState) {
                currentFilter = newFilter
                true
            } else if(currentFilter == newFilter) {
                currentFilter = null
                true
            } else {
                false
            }
        }
    }
}