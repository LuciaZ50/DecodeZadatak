package com.example.vjezba.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    companion object {
        val NULL_STRING = "null"
    }
}