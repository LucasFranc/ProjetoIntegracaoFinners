package com.example.lucasfranco.finnproject.card

import com.example.lucasfranco.finnproject.user.Balance
import com.example.lucasfranco.finnproject.user.User

interface FragmentCardCallback {

    fun refreshBalance(balance: Balance)
    fun refreshUser(user: User)
    fun showRefresh(show: Boolean)
    fun showSnackBarError(requestType: Int, error: String)

}