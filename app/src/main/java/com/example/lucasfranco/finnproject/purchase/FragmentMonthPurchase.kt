package com.example.lucasfranco.finnproject.purchase

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.mainActivity.DialogLoading
import kotlinx.android.synthetic.main.fragment_month_purchase.view.*

class FragmentMonthPurchase : Fragment(), FragmentMonthPurchaseCallback {

    val presenter = FragmentMonthPurchasePresenter()
    private val purchases = Purchases(ArrayList(), 0)
    var page = 1
    var isLoading = false
    private lateinit var loadingDialog : Dialog
    private lateinit var rootView : View

    fun newInstance(month: Int) : FragmentMonthPurchase {
        val args = Bundle()
        args.putInt("MONTH", month)
        val fragment = FragmentMonthPurchase()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_month_purchase,container,false)
        presenter.attachView(activity as AppCompatActivity, this)
        presenter.bindRecyclerView(rootView.recycler_purchase,purchases)
        presenter.bindScrollListenerToPagination(rootView.recycler_purchase)
        loadingDialog = DialogLoading(activity as Activity, getString(R.string.loading)).bind()
        return rootView
    }

    override fun refreshRecyclerView(response: Purchases) {
        isLoading = false
        purchases.purchaseList.addAll(response.purchaseList)
        rootView.recycler_purchase.adapter.notifyDataSetChanged()
    }

    override fun doRequestForPage() {
        if(!isLoading) {
            isLoading = true
            page++
            presenter.doRequestPurchases(arguments!!.getInt("MONTH"), page)
        }
    }

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if(menuVisible){
            presenter.doRequestPurchases(arguments!!.getInt("MONTH"),page)
        }
    }

    override fun showSnackBarError(s: String) {
        Snackbar.make(rootView,s,Snackbar.LENGTH_LONG).setAction(getString(R.string.try_again), {
            presenter.doRequestPurchases(arguments!!.getInt("MONTH"), page)
        })
    }

    override fun showRefresh(show: Boolean) {
        if(show) loadingDialog.show()
        else loadingDialog.hide()
    }
}