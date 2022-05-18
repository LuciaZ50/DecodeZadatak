package com.example.vjezba.ui

import com.example.vjezba.data.SearchRepository
import com.example.vjezba.ui.base.BaseViewModel

class HomeViewModel(
    private val repository: SearchRepository
) :  BaseViewModel(repository){
}