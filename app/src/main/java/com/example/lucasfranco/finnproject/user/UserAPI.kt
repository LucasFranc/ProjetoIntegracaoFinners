package com.example.lucasfranco.finnproject.user

import com.example.lucasfranco.finnproject.Constants
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {

    @GET(Constants.BALANCE_URL)
    fun getBalance() : Call<Balance>

    @GET(Constants.USERS_URL)
    fun getUser() : Call<User>

}