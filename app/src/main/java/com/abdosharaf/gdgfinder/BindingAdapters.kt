package com.abdosharaf.gdgfinder

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdosharaf.gdgfinder.network.ChapterData
import com.abdosharaf.gdgfinder.ui.fragments.list.ChaptersListAdapter

@BindingAdapter("bindRecyclerView")
fun RecyclerView.bind(list: List<ChapterData>?) {
    this.isVisible = !list.isNullOrEmpty()
    (this.adapter as ChaptersListAdapter).submitList(list)
}

@BindingAdapter("hideIfNull")
fun ProgressBar.hideIfNull(list: List<ChapterData>?){
    this.isVisible = list.isNullOrEmpty()
}