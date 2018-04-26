package com.example.lucasfranco.finnproject.user

import android.util.Log
import com.example.lucasfranco.finnproject.Constants
import com.example.lucasfranco.finnproject.RetrofitClient
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

    fun getBalance(callback: (Balance?)->Unit){
        launch(UI + errorHandler) {
            callback(RetrofitClient.get().create(UserAPI::class.java).getBalance().await())
        }
    }

    fun getUser(callback: (User?)->Unit){
        launch(UI + errorHandler) {
            callback(RetrofitClient.get().create(UserAPI::class.java).getUser().await())
        }
    }

}