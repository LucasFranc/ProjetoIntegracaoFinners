package com.example.lucasfranco.finnproject.extract

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.extract.FragmentExtractPresenter
import kotlinx.android.synthetic.main.fragment_extract.view.*

class FragmentExtract : Fragment() {

    val presenter = FragmentExtractPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_extract,container,false)
        presenter.attachView(activity as AppCompatActivity)
        presenter.bindTabLayout(rootView.tab_layout)
        presenter.bindViewPager(rootView.view_pager_extract, rootView.tab_layout)
        return rootView
    }

}