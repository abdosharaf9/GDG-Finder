package com.abdosharaf.gdgfinder.ui.fragments.addNew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdosharaf.gdgfinder.databinding.FragmentAddNewChapterBinding

class AddNewChapterFragment : Fragment() {

    private lateinit var binding: FragmentAddNewChapterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNewChapterBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
}