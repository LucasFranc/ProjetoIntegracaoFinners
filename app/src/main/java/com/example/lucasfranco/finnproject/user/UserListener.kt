package com.example.lucasfranco.finnproject.user

interface UserListener {

    fun onUserSuccess(user : User)
    fun onUserFail(error : String)
    fun onBalanceSucess(balance: Balance)
    fun onBalanceFail(error : String)

}