package com.vianabrothers.android.tvmaze.ui.searchFragment

import android.R
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.vianabrothers.android.tvmaze.databinding.SearchFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    //lateinit var showsAdapter: ShowsAdapter

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }



    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)
        val myActionMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchView = myActionMenuItem.getActionView() as SearchView
        searchView.setOnQueryTextListener(object : OnQueryTextListener() {
            fun onQueryTextSubmit(query: String): Boolean {
                // Toast like print
                UserFeedback.show("SearchOnQueryTextSubmit: $query")
                if (!searchView.isIconified()) {
                    searchView.setIconified(true)
                }
                myActionMenuItem.collapseActionView()
                return false
            }

            fun onQueryTextChange(s: String?): Boolean {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false
            }
        })
        return true
    }*/

}