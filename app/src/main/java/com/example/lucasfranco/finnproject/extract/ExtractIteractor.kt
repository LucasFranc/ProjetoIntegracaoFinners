package com.example.lucasfranco.finnproject.extract

import com.example.lucasfranco.finnproject.Constants
import com.example.lucasfranco.finnproject.purchase.PurchasesListener
import com.example.lucasfranco.finnproject.purchase.Purchases
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExtractIteractor {

    fun getExtracts(year: Int, month: Int, page: Int, listener: PurchasesListener) {

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ExtractAPI::class.java).getPurchases(year, month, page).enqueue(object : Callback<Purchases> {

            override fun onResponse(call: Call<Purchases>?, response: Response<Purchases>?) {
                if (response!!.isSuccessful)
                    listener.onRequestSuccess(response.body()!!)
                else
                    listener.onRequestFailed(response.code().toString())
            }

            override fun onFailure(call: Call<Purchases>?, t: Throwable?) {
                listener.onRequestFailed(600.toString())
            }
        })

    }

}