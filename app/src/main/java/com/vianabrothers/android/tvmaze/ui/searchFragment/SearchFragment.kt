package com.vianabrothers.android.tvmaze.ui.searchFragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.vianabrothers.android.tvmaze.adapter.SearchAdapter
import com.vianabrothers.android.tvmaze.adapter.ShowClickListener
import com.vianabrothers.android.tvmaze.databinding.SearchFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    lateinit var searchAdapter: SearchAdapter

    private val searchViewModel: SearchViewModel by viewModel()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        setUpSearchList()
    }

    private fun setUpSearchList() {
        searchAdapter = SearchAdapter(ShowClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(it)
            navController.navigate(action)
        })
        configureListGridToScreenSize()

        observeSearch()
    }

    private fun configureListGridToScreenSize() {
        if (resources.configuration.screenLayout and
            Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE ||
            resources.configuration.screenLayout and
            Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_XLARGE
        ) {
            binding.idSearchShowsList.apply {
                layoutManager = GridLayoutManager(requireContext(), 5)
                adapter = searchAdapter
            }
        } else {
            binding.idSearchShowsList.apply {
                layoutManager = GridLayoutManager(requireContext(), 3)
                adapter = searchAdapter
            }
        }
    }

    private fun observeSearch() {
        binding.idSearchTextInput.setOnEditorActionListener { editText, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                searchViewModel.searchShows(editText.text.toString())
            }
            true
        }
        searchViewModel.searchShows.observe(viewLifecycleOwner, {
            searchAdapter.submitList(it)
        })
    }

}