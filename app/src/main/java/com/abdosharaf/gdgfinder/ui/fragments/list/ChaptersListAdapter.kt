package com.abdosharaf.gdgfinder.ui.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdosharaf.gdgfinder.databinding.ItemChapterBinding
import com.abdosharaf.gdgfinder.network.ChapterData

class ChaptersListAdapter : ListAdapter<ChapterData, ChaptersViewHolder>(ChaptersDiffUtil) {

    var onItemClicked: ((ChapterData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
        return ChaptersViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClicked)
    }
}

class ChaptersViewHolder private constructor(private val binding: ItemChapterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(chapterData: ChapterData, clickListener: ((ChapterData) -> Unit)?) {
        binding.chapter = chapterData
        binding.root.setOnClickListener {
            clickListener?.invoke(chapterData)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ChaptersViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ChaptersViewHolder(
                ItemChapterBinding.inflate(layoutInflater, parent, false)
            )
        }
    }
}

object ChaptersDiffUtil : DiffUtil.ItemCallback<ChapterData>() {
    override fun areItemsTheSame(oldItem: ChapterData, newItem: ChapterData): Boolean {
        return newItem === oldItem
    }

    override fun areContentsTheSame(oldItem: ChapterData, newItem: ChapterData): Boolean {
        return newItem == oldItem
    }
}