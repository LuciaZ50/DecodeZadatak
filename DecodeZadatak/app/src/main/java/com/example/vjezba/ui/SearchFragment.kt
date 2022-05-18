package com.example.vjezba.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vjezba.R
import com.example.vjezba.data.*
import com.example.vjezba.databinding.FragmentHomeBinding
import com.example.vjezba.databinding.FragmentSearchBinding
import com.example.vjezba.ui.base.BaseFragment
import com.example.vjezba.ui.base.RepositoryRecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding, SearchRepository>() {

    private lateinit var mContext: Context
    private var reposList = ArrayList<RepositoriesResponse>().toList()
    private lateinit var adapterRepo: RepositoryRecyclerAdapter
    private lateinit var linearLayoutManagerDistance: LinearLayoutManager




    val args: SearchFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = this.requireContext()

        linearLayoutManagerDistance = LinearLayoutManager(mContext)
        linearLayoutManagerDistance.orientation = LinearLayoutManager.VERTICAL
        binding.repositoriesList.layoutManager = linearLayoutManagerDistance


        val query = args.query

        val apiInterface = RepositoryApi.create().getRepositoriesByQuery(query)


        apiInterface.enqueue( object : Callback<QueryResponse> {
            override fun onResponse(call: Call<QueryResponse>?, response: Response<QueryResponse>?) {
                if(response?.body() != null){
                    reposList = response.body()!!.items
                    adapterRepo = RepositoryRecyclerAdapter(reposList)
                    binding.repositoriesList.adapter = adapterRepo

                }

            }

            override fun onFailure(call: Call<QueryResponse>?, t: Throwable?) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_LONG).show()
            }


        })




    }




    override fun getViewModel() = SearchViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()=
        SearchRepository()
}