package com.vianabrothers.android.tvmaze.ui.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.vianabrothers.android.tvmaze.adapter.ShowClickListener
import com.vianabrothers.android.tvmaze.adapter.ShowsAdapter
import com.vianabrothers.android.tvmaze.databinding.MainFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    lateinit var showsAdapter: ShowsAdapter

    private lateinit var binding: MainFragmentBinding

    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        setUpShowsList()
        setUpSearchNavigation()
    }

    private fun setUpSearchNavigation() {
        binding.idSearchFab.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSearchFragment()
            navController.navigate(action)
        }
    }

    private fun setUpShowsList() {
        showsAdapter = ShowsAdapter(ShowClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(it)
            navController.navigate(action)
        })
        binding.idShowsList.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = showsAdapter
        }
        lifecycleScope.launch {
            mainFragmentViewModel.flow.collectLatest { pagingData ->
                showsAdapter.submitData(pagingData)
            }
        }
    }

}