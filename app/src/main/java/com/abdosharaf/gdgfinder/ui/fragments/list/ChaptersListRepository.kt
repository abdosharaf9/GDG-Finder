package com.abdosharaf.gdgfinder.ui.fragments.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdosharaf.gdgfinder.Constants.TAG
import com.abdosharaf.gdgfinder.network.ChapterData
import com.abdosharaf.gdgfinder.network.ChaptersResponse
import com.abdosharaf.gdgfinder.network.apiService

class ChaptersListRepository {

    private var chaptersResponse: ChaptersResponse? = null

    private val _chaptersList = MutableLiveData<List<ChapterData>?>()
    val chaptersList: LiveData<List<ChapterData>?>
        get() = _chaptersList

    private val _filtersList = MutableLiveData<List<String>?>()
    val filtersList: LiveData<List<String>?>
        get() = _filtersList

    private val filter = Filter()

    suspend fun getChapters() {
        try {
            chaptersResponse = apiService.getChapters()
            _chaptersList.value = chaptersResponse?.data
            _filtersList.value = chaptersResponse?.filters_?.region
        } catch (e: Exception) {
            Log.e(TAG, "getChapters: ${e.message}")
        }
    }

    fun onFilterChanged(newFilter: String, checked: Boolean) {
        if (filter.updateFilter(newFilter, checked)) {
            updateList(newFilter)
        } else {
            _chaptersList.value = chaptersResponse?.data
        }
    }

    private fun updateList(filter: String) {
        val list = chaptersResponse?.data?.filter {
            it.region == filter
        }
        _chaptersList.value = list
    }

    private inner class Filter {
        var currentFilter: String? = null
            private set

        fun updateFilter(newFilter: String, newState: Boolean): Boolean {
            return if (newState) {
                currentFilter = newFilter
                true
            } else {
                currentFilter = null
                false
            }
        }
    }
}