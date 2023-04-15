package com.abdosharaf.gdgfinder.ui.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdosharaf.gdgfinder.network.ChapterData
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val repo = ChaptersListRepository()

    val chaptersList: LiveData<List<ChapterData>?>
        get() = repo.chaptersList

    val filters: LiveData<List<String>?>
        get() = repo.filtersList

    init {
        getChapters()
    }

    private fun getChapters() {
        viewModelScope.launch {
            repo.getChapters()
        }
    }

    fun onFilterChanged(filter: String, checked: Boolean) {
        repo.onFilterChanged(filter, checked)
    }
}