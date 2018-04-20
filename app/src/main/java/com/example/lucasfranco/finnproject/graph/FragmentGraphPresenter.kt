package com.example.lucasfranco.finnproject.graph

import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.example.lucasfranco.finnproject.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.util.*

class FragmentGraphPresenter {

    private lateinit var activity: AppCompatActivity

    fun attachView(activity: AppCompatActivity) {
     this.activity = activity
    }

    fun bindGraph(graph: BarChart) {

        val entries = ArrayList<BarEntry>()

        val dataObjects = ArrayList<GraphModel>()

        dataObjects.add(GraphModel(15F, 19F))
        dataObjects.add(GraphModel(13F, 18F))
        dataObjects.add(GraphModel(16F, 13F))
        dataObjects.add(GraphModel(12F, 30F))
        dataObjects.add(GraphModel(16F, 26F))
        dataObjects.add(GraphModel(17F, 23F))
        dataObjects.add(GraphModel(10F, 28F))

        for (data in dataObjects) {
            entries.add(BarEntry(data.x, data.y))
        }

        val dataSet = BarDataSet(entries,"Gastos")
        dataSet.colors = returnListColorsMock()
        graph.data = BarData(dataSet)
        val description = Description()
        description.text = ""
        graph.description = description
        graph.setScaleEnabled(false)
        graph.setPinchZoom(false)
        graph.isDoubleTapToZoomEnabled = false
        graph.invalidate()
    }

    private fun returnListColorsMock(): List<Int>{
        val list = ArrayList<Int>()
        list.add(ContextCompat.getColor(activity,R.color.colorPrimary))
        list.add(ContextCompat.getColor(activity,R.color.colorAccent))
        list.add(ContextCompat.getColor(activity,R.color.colorPrimaryDark))
        list.add(ContextCompat.getColor(activity,R.color.red))
        return list
    }

}