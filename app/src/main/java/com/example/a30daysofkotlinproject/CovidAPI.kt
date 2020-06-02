package com.example.a30daysofkotlinproject

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CovidAPI {

    @GET("countries")
   suspend fun getCovid() : Response<List<CovidItem>>

    companion object{
        operator fun invoke() : CovidAPI{

           return Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidAPI::class.java)

        }
    }

}