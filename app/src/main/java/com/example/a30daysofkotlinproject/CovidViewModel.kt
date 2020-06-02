package com.example.a30daysofkotlinproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class CovidViewModel(private val repository: CovidRepository) : ViewModel() {

    private lateinit var job: Job

    private val _covid = MutableLiveData<List<CovidItem>>()
    val covid : LiveData<List<CovidItem>>
        get() = _covid


    fun getCovid(){
        job = Coroutines.ioThenMain(
            {  repository.getCovid()},
            {_covid.value = it})
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()

    }

}
