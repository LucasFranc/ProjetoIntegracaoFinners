package com.example.lucasfranco.finnproject.purchase

interface PurchasesListener {

    fun onRequestSuccess(response : Purchases)
    fun onRequestFailed(error: String)

}