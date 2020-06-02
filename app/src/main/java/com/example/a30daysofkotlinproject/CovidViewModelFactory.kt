package com.example.a30daysofkotlinproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class CovidViewModelFactory(private val repository: CovidRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CovidViewModel(repository) as T
    }
}