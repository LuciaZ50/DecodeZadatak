package com.example.vjezba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vjezba.data.QueryResponse
import com.example.vjezba.data.RepositoriesResponse
import com.example.vjezba.data.RepositoryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiInterface = RepositoryApi.create().getRepositoriesByQuery("kotlin")


        apiInterface.enqueue( object : Callback<QueryResponse> {
            override fun onResponse(call: Call<QueryResponse>?, response: Response<QueryResponse>?) {
                //Toast.makeText(this@MainActivity, "Null", Toast.LENGTH_LONG).show()
                if(response?.body() != null)
                    Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<QueryResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
            }
        })

        }
    }



