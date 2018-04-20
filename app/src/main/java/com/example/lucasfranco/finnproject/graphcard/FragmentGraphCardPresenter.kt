package com.example.lucasfranco.finnproject.graphcard

import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class FragmentGraphCardPresenter{

    lateinit var activity : AppCompatActivity

    fun attachView(activity: AppCompatActivity) {
        this.activity = activity
    }

    fun bindViewPager(viewPagerCardGraph: ViewPager?) {
        viewPagerCardGraph!!.adapter = GraphCardPagerAdapter(activity.supportFragmentManager)
    }


}