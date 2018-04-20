package com.example.lucasfranco.finnproject.card

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.Constants
import com.example.lucasfranco.finnproject.R
import com.example.lucasfranco.finnproject.user.Balance
import com.example.lucasfranco.finnproject.user.User
import com.example.lucasfranco.finnproject.mainActivity.DialogLoading
import kotlinx.android.synthetic.main.fragment_card.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class FragmentCard : Fragment(), FragmentCardCallback {

    val presenter = FragmentCardPresenter()
    private lateinit var loadingDialog: Dialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_card, container, false)
        presenter.attachView(activity as AppCompatActivity, this)
        loadingDialog = DialogLoading(activity as Activity, getString(R.string.loading)).bind()
        presenter.doRequestBalance()
        presenter.doRequestUser()
        return rootView
    }

    override fun refreshBalance(balance: Balance) {
        txt_balance.text = formatMoney(balance.balance)
    }

    override fun refreshUser(user: User) {
        txt_name.text = user.name
        txt_card_number.text = "**** **** **** " + user.cardNumber.substring(12)
        txt_validity.text = formatDate(user.expirationDate)
    }

    private fun formatMoney(balance: Double): CharSequence? {
        val df = DecimalFormat("R$ ###,###,###,###,##0.00", DecimalFormatSymbols(Locale("pt", "BR")))
        return df.format(balance)
    }

    private fun formatDate(expirationDate: Date): CharSequence? {
        val formatter = SimpleDateFormat("MM/yy", Locale.ROOT)
        return formatter.format(expirationDate)
    }

    override fun showSnackBarError(requestType: Int, error: String) {
        when (requestType) {
            Constants.REQUEST_TYPE_BALANCE ->
                Snackbar.make(activity!!.currentFocus, error, Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.try_again), { presenter.doRequestBalance() })
            Constants.REQUEST_TYPE_USER ->
                Snackbar.make(activity!!.currentFocus, error, Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.try_again), { presenter.doRequestUser() })
        }
    }

    override fun showRefresh(show: Boolean) {
        if (show) loadingDialog.show()
        else loadingDialog.hide()
    }

}