package com.example.lucasfranco.finnproject.card

import android.support.v7.app.AppCompatActivity
import com.example.lucasfranco.finnproject.Constants
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.user.UserIteractor
import com.example.lucasfranco.finnproject.user.UserListener
import com.example.lucasfranco.finnproject.user.Balance
import com.example.lucasfranco.finnproject.user.User

class FragmentCardPresenter{


    private lateinit var activity: AppCompatActivity
    private val iteractor = UserIteractor()
    private lateinit var callback: FragmentCardCallback

    fun attachView(activity: AppCompatActivity, callback: FragmentCardCallback) {
        this.activity = activity
        this.callback = callback
    }

    fun doRequestBalance() {
        iteractor.getBalance(
                { balance ->
                    callback.refreshBalance(balance!!)
                }, { error ->
            callback.showRefresh(false)
            callback.showSnackBarError(Constants.REQUEST_TYPE_BALANCE, error.message!!)
        })
    }

    fun doRequestUser() {
        callback.showRefresh(true)
        iteractor.getUser({ user ->
            callback.showRefresh(false)
            callback.refreshUser(user!!)
        }, { error ->
            callback.showRefresh(false)
            callback.showSnackBarError(Constants.REQUEST_TYPE_USER, error.message!!)
        })
    }

}
