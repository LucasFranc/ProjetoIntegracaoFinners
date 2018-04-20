package com.example.lucasfranco.finnproject.user

import com.example.lucasfranco.finnproject.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class UserIteractor {

    fun getBalance(listener : UserListener){

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(UserAPI::class.java).getBalance().enqueue(object : Callback<Balance> {

            override fun onResponse(call: Call<Balance>?, response: Response<Balance>?) {
                if(response!!.isSuccessful) listener.onBalanceSucess(response.body()!!)
                else listener.onBalanceFail(response.code().toString())
            }

            override fun onFailure(call: Call<Balance>?, t: Throwable?) {
                listener.onBalanceFail(600.toString())
            }
        })

    }

    fun getUser(listener : UserListener){
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(UserAPI::class.java).getUser().enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if(response!!.isSuccessful) listener.onUserSuccess(response.body()!!)
                else listener.onUserFail(response.code().toString())
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                listener.onUserFail(600.toString())
            }
        })

    }

}