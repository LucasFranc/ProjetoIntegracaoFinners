package com.example.lucasfranco.finnproject.extract

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import java.text.DateFormatSymbols

class FragmentExtractPresenter {

    private lateinit var activity: AppCompatActivity

    fun attachView(activity: AppCompatActivity) {
        this.activity = activity
    }

    fun bindTabLayout(tabLayout: TabLayout) {
        DateFormatSymbols().months.forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it.capitalize()))
        }
    }

    fun bindViewPager(viewPagerExtract: ViewPager, tabLayout: TabLayout) {
        viewPagerExtract.adapter = ExtractPagerAdapter(activity, tabLayout.tabCount)
        viewPagerExtract.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPagerExtract.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

    }

}