package com.example.lucasfranco.finnproject.mainActivity

import android.support.v7.app.AppCompatActivity
import com.example.lucasfranco.finnproject.extract.FragmentExtract
import com.example.lucasfranco.finnproject.graphcard.FragmentGraphCard

class MainActivityPresenter {

    lateinit var activity : AppCompatActivity

    fun attachView(activity: AppCompatActivity) {
        this.activity = activity
    }

    fun bindCardGraphFragment(fragmentCardGraph: Int) {
        activity.supportFragmentManager.beginTransaction().replace(
               fragmentCardGraph, FragmentGraphCard()).commit()
    }

    fun bindExtractFragment(fragmentExtract: Int) {
        activity.supportFragmentManager.beginTransaction().replace(
                fragmentExtract, FragmentExtract()).commit()
    }

}