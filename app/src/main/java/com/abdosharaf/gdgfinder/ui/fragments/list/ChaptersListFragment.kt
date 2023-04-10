package com.abdosharaf.gdgfinder.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.abdosharaf.gdgfinder.databinding.FragmentChaptersListBinding

class ChaptersListFragment : Fragment() {

    private lateinit var binding: FragmentChaptersListBinding
    private val adapter = ChaptersListAdapter()
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChaptersListBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvChapters.adapter = adapter

        return binding.root
    }
}