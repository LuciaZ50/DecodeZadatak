package com.example.vjezba.ui.base

import androidx.lifecycle.ViewModel
import com.example.vjezba.data.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {

}