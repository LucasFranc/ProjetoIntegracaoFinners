package com.example.lucasfranco.finnproject.purchase

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.extract.ExtractIteractor

class FragmentMonthPurchasePresenter : PurchasesListener {

    private lateinit var activity: AppCompatActivity
    private lateinit var callback: FragmentMonthPurchaseCallback
    private val iteractor = ExtractIteractor()
    private var lastPage = 0
    private var page = 1

    fun attachView(activity : AppCompatActivity, callback : FragmentMonthPurchaseCallback){
        this.activity = activity
        this.callback = callback
    }

    fun bindRecyclerView(recyclerPurchase: RecyclerView, purchases: Purchases) {
        if(recyclerPurchase.adapter == null){
            recyclerPurchase.layoutManager = LinearLayoutManager(activity,LinearLayout.VERTICAL,false)
            recyclerPurchase.adapter = PurchasesAdapter(activity, purchases)
        }else{
            recyclerPurchase.adapter.notifyDataSetChanged()
        }
    }

    fun bindScrollListenerToPagination(recyclerPurchase: RecyclerView) {
        recyclerPurchase.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = recyclerPurchase.layoutManager.childCount
                val totalItemCount = recyclerPurchase.layoutManager.itemCount
                val firstVisibleItemPosition = ((recyclerPurchase.layoutManager)as LinearLayoutManager).findFirstVisibleItemPosition()

                if (page < lastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= 10) {
                        callback.showRefresh(true)
                        callback.doRequestForPage()
                    }
                }
            }
        })
    }

    fun doRequestPurchases(month: Int, page: Int) {
        this.page = page
        iteractor.getExtracts(2017,month,page,this)
    }

    override fun onRequestSuccess(response: Purchases) {
        callback.showRefresh(false)
        lastPage = response.lastPage
        callback.refreshRecyclerView(response)
    }

    override fun onRequestFailed(error: String){
        callback.showRefresh(false)
        callback.showSnackBarError(activity.getString(R.string.code_error) + error)
    }

}