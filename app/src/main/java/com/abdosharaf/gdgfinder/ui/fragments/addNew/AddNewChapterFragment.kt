package com.abdosharaf.gdgfinder.ui.fragments.addNew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdosharaf.gdgfinder.R
import com.abdosharaf.gdgfinder.databinding.FragmentAddNewChapterBinding
import com.google.android.material.snackbar.Snackbar

class AddNewChapterFragment : Fragment() {

    private lateinit var binding: FragmentAddNewChapterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNewChapterBinding.inflate(layoutInflater, container, false)

        binding.btnSubmit.setOnClickListener {
            disableAllInputs()
            Snackbar.make(requireView(), R.string.application_submitted, Snackbar.LENGTH_SHORT).show()

            binding.btnSubmit.contentDescription = getString(R.string.submitted)
            binding.btnSubmit.text = getString(R.string.done)
            binding.btnSubmit.isEnabled = false
        }

        return binding.root
    }

    private fun disableAllInputs() {
        binding.etChapterName.isEnabled = false
        binding.etEmail.isEnabled = false
        binding.etCity.isEnabled = false
        binding.etCountry.isEnabled = false
        binding.etRegion.isEnabled = false
        binding.etMotivation.isEnabled = false
    }
}