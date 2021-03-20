package com.vianabrothers.android.tvmaze.ui.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.vianabrothers.android.tvmaze.adapter.ShowsAdapter
import com.vianabrothers.android.tvmaze.databinding.MainFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    lateinit var showsAdapter: ShowsAdapter

    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        mainFragmentViewModel.getListShows(0)
        observeLiveData()
        setUpShowsList()
    }

    private fun setUpShowsList() {
        showsAdapter = ShowsAdapter()
        binding.idShowsList.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = showsAdapter
        }
    }

    private fun observeLiveData() {
        mainFragmentViewModel.shows.observe(viewLifecycleOwner, {
            showsAdapter.submitList(it)
        })
    }

}