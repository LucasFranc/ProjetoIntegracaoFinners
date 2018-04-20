package com.example.lucasfranco.finnproject.extract

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.lucasfranco.finnproject.purchase.FragmentMonthPurchase

class ExtractPagerAdapter(
        val activity: AppCompatActivity,
        val tabCount: Int
) : FragmentStatePagerAdapter(activity.supportFragmentManager) {


    override fun getItem(position: Int): Fragment {
        return FragmentMonthPurchase().newInstance(position + 1)
    }

    override fun getCount(): Int {
        return tabCount
    }


}