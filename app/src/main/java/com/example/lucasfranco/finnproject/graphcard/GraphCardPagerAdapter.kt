package com.example.lucasfranco.finnproject.graphcard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.lucasfranco.finnproject.card.FragmentCard
import com.example.lucasfranco.finnproject.graph.FragmentGraph

class GraphCardPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FragmentCard()
            1 -> FragmentGraph()
            else -> FragmentCard()
        }
    }

    override fun getCount(): Int {
        return 2
    }


}