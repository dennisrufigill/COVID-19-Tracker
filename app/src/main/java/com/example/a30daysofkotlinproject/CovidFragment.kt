package com.example.a30daysofkotlinproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.covid_fragment.*


class CovidFragment : Fragment() {

    private lateinit var viewModel: CovidViewModel
    private lateinit var factory: CovidViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.covid_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = CovidAPI()
        val repository = CovidRepository(api)
        factory = CovidViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(CovidViewModel::class.java)
        viewModel.getCovid()
        viewModel.covid.observe(viewLifecycleOwner, Observer { covid->
            recyclerview_covid.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.addItemDecoration(
                    DividerItemDecoration(
                    context,
                    LinearLayoutManager.HORIZONTAL))
                it.adapter = CovidAdapter(covid)


            }
        })


    }

}
