package com.example.vjezba.ui.base

import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.vjezba.R
import com.example.vjezba.data.Owner
import com.example.vjezba.data.RepositoriesResponse
import com.example.vjezba.ui.SearchFragmentDirections
import com.example.vjezba.ui.SearchPlaceHolder


class RepositoryRecyclerAdapter(repos: List<RepositoriesResponse>): RecyclerView.Adapter<SearchPlaceHolder>(){

    private var repoList = repos
    var navc: NavController?= null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPlaceHolder {
        val inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pravokutnik, parent, false);
        return SearchPlaceHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchPlaceHolder, position: Int) {
        val repo = repoList[position]
        holder.bindRepo(repo)



        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                var navc = Navigation.findNavController(view)



               // Toast.makeText(view.getContext(), "Clicked",Toast.LENGTH_LONG).show()
                val action = SearchFragmentDirections.actionSearchFragmentToRepoFragment(repo.owner.login, repo.full_name)
                navc?.navigate(action)
            }
        })
    }



    override fun getItemCount() = repoList.size



}