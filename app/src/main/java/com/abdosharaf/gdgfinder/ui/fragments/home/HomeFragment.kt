package com.abdosharaf.gdgfinder.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abdosharaf.gdgfinder.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnGoToList.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToChaptersListFragment())
        }

        binding.btnAddNewChapter.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddNewChapterFragment())
        }

        return binding.root
    }
}