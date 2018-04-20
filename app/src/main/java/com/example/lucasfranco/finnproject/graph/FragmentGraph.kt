package com.example.lucasfranco.finnproject.graph

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.graph.FragmentGraphPresenter

class FragmentGraph : Fragment() {

    private val presenter = FragmentGraphPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_graph,container,false)
        presenter.attachView(activity as AppCompatActivity)
        presenter.bindGraph(rootView.findViewById(R.id.graph))
        return rootView
    }

}