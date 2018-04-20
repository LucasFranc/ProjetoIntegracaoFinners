package com.example.lucasfranco.finnproject.purchase

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucasfranco.finnproject.R
import kotlinx.android.synthetic.main.item_view_purchase.view.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class PurchasesAdapter(val activity: AppCompatActivity, private val purchases: Purchases) : RecyclerView.Adapter<PurchasesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(activity).inflate(R.layout.item_view_purchase,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val finalPosition = holder.adapterPosition
        holder.txtBuy.text = purchases.purchaseList[finalPosition].description
        holder.txtMarket.text = purchases.purchaseList[finalPosition].store
        holder.txtValue.text = formatMoney(purchases.purchaseList[finalPosition].value)
    }

    private fun formatMoney(balance: Double): CharSequence? {
        val df = DecimalFormat("R$ ###,###,###,###,##0.00", DecimalFormatSymbols(Locale("pt", "BR")))
        return df.format(balance)
    }

    override fun getItemCount(): Int {
        return purchases.purchaseList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMarket = itemView.txt_market
        val txtBuy = itemView.txt_buy
        val txtValue = itemView.txt_purchase_value
    }

}
