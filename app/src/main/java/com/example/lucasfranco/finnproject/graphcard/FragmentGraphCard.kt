package com.example.lucasfranco.finnproject.graphcard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.R

class FragmentGraphCard : Fragment() {

    private val presenter = FragmentGraphCardPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_card_graph,container,false)
        presenter.attachView(activity as AppCompatActivity)
        presenter.bindViewPager(rootView.findViewById(R.id.view_pager_card_graph))
        return rootView
    }

}