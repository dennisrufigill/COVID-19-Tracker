package com.example.a30daysofkotlinproject

class CovidRepository(private val api : CovidAPI) : SafeApiRequest() {

    suspend fun getCovid() = apiRequest{api.getCovid()}
}