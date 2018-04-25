package com.example.lucasfranco.finnproject.user

interface UserListener {

    fun onUserSuccess(user : User)
    fun onUserFail(error : String)
    fun onBalanceFail(error : String)

}