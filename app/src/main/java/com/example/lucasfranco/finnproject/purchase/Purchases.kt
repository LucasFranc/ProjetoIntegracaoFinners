package com.example.lucasfranco.finnproject.purchase

import com.example.lucasfranco.finnproject.purchase.Purchase
import com.google.gson.annotations.SerializedName

class Purchases(
        @SerializedName("purchases")
        var purchaseList : ArrayList<Purchase>,
        var lastPage : Int = 0
)