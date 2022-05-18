package com.example.vjezba.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoryApi {

    @GET("repositories")
    fun getRepositories(): Call<List<RepositoriesResponse>>

    @GET("search/repositories")
    fun getRepositoriesByQuery(@Query("q") Query : String): Call<QueryResponse>

    @GET("repos/{owner}/{repo}")
    fun getOwnerRepo(@Path("owner")owner: String, @Path("repo")repo: String) :Call<RepositoriesResponse>


    //@GET("place/{id}")
    //suspend fun getPlace(@Path("id") PlaceId : Long): Place

    companion object {

        var myURL = "https://api.github.com/"

        fun create(): RepositoryApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(myURL)
                .build()
            return retrofit.create(RepositoryApi::class.java)
        }
    }



}