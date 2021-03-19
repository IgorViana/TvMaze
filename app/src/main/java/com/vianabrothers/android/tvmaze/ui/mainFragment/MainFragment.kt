package com.vianabrothers.android.tvmaze.ui.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vianabrothers.android.tvmaze.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding

    private val mainFragmentViewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}