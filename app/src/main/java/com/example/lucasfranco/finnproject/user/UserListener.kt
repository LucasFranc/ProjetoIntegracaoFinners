package com.example.lucasfranco.finnproject.user

interface UserListener {

    fun onUserFail(error : String)
    fun onBalanceFail(error : String)

}