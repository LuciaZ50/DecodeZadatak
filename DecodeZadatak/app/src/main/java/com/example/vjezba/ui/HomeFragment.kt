package com.example.vjezba.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.vjezba.R
import com.example.vjezba.data.SearchRepository
import com.example.vjezba.ui.base.BaseFragment
import com.example.vjezba.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, SearchRepository>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var mySearchView = view.findViewById<SearchView>(R.id.search_view)
        var navc = Navigation.findNavController(view)

        mySearchView.setIconifiedByDefault(true);
        mySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment2(query)
                navc?.navigate(action)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()=
        SearchRepository()

}



