package com.nhom12.rau_cu_xanh.api.login

import com.nhom12.rau_cu_xanh.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface login_Api {

    companion object {

        var BASE_URL = "http://192.168.0.101:5090/"

        fun create() : login_Api {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(login_Api::class.java)

        }
    }

//
//    @GET("volley_array.json")
//    fun getMovies() : Call<List<Movie>>

//    @GET("api/v1/resources/books")
//    fun getMovies() : Call<List<User>>


    @GET("api/v1/resources/books")
    fun getBook_id(@Query("id") id: Int): Call<Array<User?>?>?
}



