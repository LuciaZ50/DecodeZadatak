package com.example.vjezba.ui

import com.example.vjezba.data.SearchRepository
import com.example.vjezba.ui.base.BaseViewModel

class RepoViewModel (
    private val repository: SearchRepository
) : BaseViewModel(repository) {

}
