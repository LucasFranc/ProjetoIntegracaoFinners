package com.example.lucasfranco.finnproject.mainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lucasfranco.finnproject.R

class MainActivity : AppCompatActivity() {

    private val presenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        presenter.bindCardGraphFragment(R.id.fragment_card_graph)
        presenter.bindExtractFragment(R.id.fragment_extract)

    }
}
