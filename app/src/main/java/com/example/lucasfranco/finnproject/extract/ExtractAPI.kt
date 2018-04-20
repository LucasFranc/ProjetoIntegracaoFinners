package com.example.lucasfranco.finnproject.extract

import com.example.lucasfranco.finnproject.Constants
import com.example.lucasfranco.finnproject.purchase.Purchases
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExtractAPI {


    @GET(Constants.EXTRACT_URL)
    fun getPurchases(
            @Query("year") year: Int,
            @Query("month") month: Int,
            @Query("page") page: Int
    ) : Call<Purchases>
}