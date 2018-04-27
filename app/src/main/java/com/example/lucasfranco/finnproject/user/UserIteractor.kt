package com.example.lucasfranco.finnproject.user

import com.example.lucasfranco.finnproject.RetrofitClient
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import ru.gildor.coroutines.retrofit.await


class UserIteractor {

    private fun errorHandler(onError: (Throwable)-> Unit): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, throwable ->
            onError(throwable)
        }
    }

    fun getBalance(onSuccess: (Balance?)-> Unit, onError: (Throwable)-> Unit ){
        launch(UI + errorHandler(onError)) {
            onSuccess(RetrofitClient.get().create(UserAPI::class.java).getBalance().await())
        }
    }

    fun getUser(callback: (User?)->Unit,onError: (Throwable)-> Unit){
        launch(UI + errorHandler(onError)) {
            callback(RetrofitClient.get().create(UserAPI::class.java).getUser().await())
        }
    }

}