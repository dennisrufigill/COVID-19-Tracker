package com.example.a30daysofkotlinproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysofkotlinproject.databinding.CovidItemBinding

class CovidAdapter(private val covid : List<CovidItem>) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {


    inner class CovidViewHolder(val covidItemBinding: CovidItemBinding) : RecyclerView.ViewHolder(covidItemBinding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CovidViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.covid_item, parent,false)
    )

    override fun getItemCount() = covid.size


    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        holder.covidItemBinding.covid = covid[position]
    }

}