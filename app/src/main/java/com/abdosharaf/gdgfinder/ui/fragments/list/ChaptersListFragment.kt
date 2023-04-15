package com.abdosharaf.gdgfinder.ui.fragments.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.abdosharaf.gdgfinder.R
import com.abdosharaf.gdgfinder.databinding.FragmentChaptersListBinding
import com.google.android.material.chip.Chip

class ChaptersListFragment : Fragment() {

    private lateinit var binding: FragmentChaptersListBinding
    private val adapter = ChaptersListAdapter()
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChaptersListBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvChapters.adapter = adapter

        adapter.onItemClicked = { chapter ->
            val destination = Uri.parse(chapter.website)
            startActivity(Intent(Intent.ACTION_VIEW, destination))
        }

        viewModel.filters.observe(viewLifecycleOwner) { filters ->
            val chipsGroup = binding.filters
            val inflaterVar = LayoutInflater.from(chipsGroup.context)

            val chips = filters?.map { item ->
                val chip = inflaterVar.inflate(R.layout.item_chip, chipsGroup, false) as Chip
                chip.text = item
                chip.tag = item
                chip.setOnCheckedChangeListener { buttonView, isChecked ->
                    viewModel.onFilterChanged(buttonView.tag as String, isChecked)
                }
                chip
            }

            chipsGroup.removeAllViews()
            chips?.forEach { chip ->
                chipsGroup.addView(chip)
            }
        }

        return binding.root
    }
}