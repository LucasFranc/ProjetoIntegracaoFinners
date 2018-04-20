package com.example.lucasfranco.finnproject.purchase

interface FragmentMonthPurchaseCallback {

    fun refreshRecyclerView(response: Purchases)
    fun showRefresh(show: Boolean)
    fun doRequestForPage()
    fun showSnackBarError(s: String)
}
