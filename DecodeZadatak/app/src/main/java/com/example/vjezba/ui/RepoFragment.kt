package com.example.vjezba.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vjezba.R
import com.example.vjezba.data.QueryResponse
import com.example.vjezba.data.RepositoriesResponse
import com.example.vjezba.data.RepositoryApi
import com.example.vjezba.data.SearchRepository
import com.example.vjezba.databinding.FragmentHomeBinding
import com.example.vjezba.databinding.FragmentRepoBinding
import com.example.vjezba.databinding.FragmentSearchBinding
import com.example.vjezba.ui.base.BaseFragment
import com.example.vjezba.ui.base.RepositoryRecyclerAdapter
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoFragment : BaseFragment<RepoViewModel, FragmentRepoBinding, SearchRepository>(){

    private lateinit var mContext: Context
    private lateinit var linearLayoutManagerDistance: LinearLayoutManager
    val args: RepoFragmentArgs by navArgs()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repoName = args.repo
        val owner =args.owner

        mContext = this.requireContext()


        val repoIme = repoName.split("/")[1]
        val apiInterface = RepositoryApi.create().getOwnerRepo(owner, repoIme)

        view.findViewById<Button>(R.id.button).setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/"+repoIme))
            startActivity(i)
        }


        apiInterface.enqueue( object : Callback<RepositoriesResponse> {
            override fun onResponse(call: Call<RepositoriesResponse>?, response: Response<RepositoriesResponse>?) {
                if(response?.body() != null){
                    val repo = response.body()!!
                    binding.reponame.text = repo.name
                    binding.ime.text = repo.owner.login
                    val img = view.findViewById<ImageView>(R.id.avatar)
                    Picasso.get().load(repo.owner.avatar_url).into(img)



                }

            }

            override fun onFailure(call: Call<RepositoriesResponse>?, t: Throwable?) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_LONG).show()
            }


        })



    }

    override fun getViewModel() = RepoViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRepoBinding.inflate(inflater, container, false)


    override fun getFragmentRepository() = SearchRepository()



}