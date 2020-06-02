package com.example.a30daysofkotlinproject


import com.google.gson.annotations.SerializedName

data class CovidItem(
    val active: Int,
    val cases: Int,
    val casesPerOneMillion: Int,
    val country: String,
    val critical: Int,
    val deaths: Int,
    val deathsPerOneMillion: Int,
    val recovered: Int,
    val testsPerOneMillion: Int,
    val todayCases: Int,
    val todayDeaths: Int,
    val totalTests: Int
)