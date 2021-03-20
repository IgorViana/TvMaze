package com.vianabrothers.android.tvmaze.ui.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.vianabrothers.android.tvmaze.databinding.MainFragmentBinding
import com.vianabrothers.android.tvmaze.model.Show
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding

    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        Log.i("TESTE", "INICIOU")
        mainFragmentViewModel.getListShows(0)
        mainFragmentViewModel.shows.observe(viewLifecycleOwner, Observer {
            printList(it)
        })
        return binding.root
    }

    private fun printList(lista: List<Show>) {
        for (item in lista) {
            Log.i("TESTE", item.toString())
        }
    }

}