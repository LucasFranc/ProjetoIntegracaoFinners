package com.example.lucasfranco.finnproject.user

import android.util.Log
import com.example.lucasfranco.finnproject.Constants
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import ru.gildor.coroutines.retrofit.await


class UserIteractor {

    private val errorHandler = CoroutineExceptionHandler{_,throwable ->
        Log.i("teste","teste")
    }

    fun getBalance(callback: (Balance)->Unit){
        launch(UI + errorHandler) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val result = retrofit.create(UserAPI::class.java).getBalance().await()

            callback(result)
        }
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