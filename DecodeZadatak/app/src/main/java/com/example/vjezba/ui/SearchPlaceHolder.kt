package com.example.vjezba.ui

import android.accounts.AccountManager.get
import android.content.Context
import android.view.View
import android.view.ViewConfiguration.get
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vjezba.R
import com.example.vjezba.data.RepositoriesResponse
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import java.nio.file.Paths.get


class SearchPlaceHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    private var view: View = v
    private var repo: RepositoriesResponse?= null

    init {
        v.setOnClickListener(this)
    }

    fun bindRepo(repo: RepositoriesResponse) {
        this.repo = repo
        view.findViewById<TextView>(R.id.repoName).text =  repo.name
        view.findViewById<TextView>(R.id.repoOwner).text =  repo.owner.login

        val img = view.findViewById<ImageView>(R.id.img)
        Picasso.get().load(repo.owner.avatar_url).into(img)


    }

    override fun onClick(v: View) {
    }
}