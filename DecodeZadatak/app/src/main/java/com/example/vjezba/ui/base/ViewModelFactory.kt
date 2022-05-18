package com.example.vjezba.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vjezba.data.BaseRepository
import com.example.vjezba.data.SearchRepository
import com.example.vjezba.ui.RepoViewModel
import com.example.vjezba.ui.SearchViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(repository as SearchRepository) as T
            modelClass.isAssignableFrom(RepoViewModel::class.java) -> RepoViewModel(repository as SearchRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}