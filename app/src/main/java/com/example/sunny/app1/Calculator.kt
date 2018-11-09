package com.example.sunny.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_calculator.*
import org.w3c.dom.Text

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val cost = Cost_Amount_Input
        val tax = Tax_Amount_Input
        val cost_total = Price_Total
        val tax_total = Tax_Total




        cost.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val price_tax: Float
                val price: Float

                if (!cost.text.isNullOrEmpty() && !tax.text.isNullOrEmpty()) {
                    val price_tax = java.lang.Float.parseFloat(tax.text.toString())
                    val price = java.lang.Float.parseFloat(cost.text.toString())
                    val total_tax = price * price_tax / 100
                    val price_plus_tax = price + total_tax
                    cost_total.setText(price_plus_tax.toString())
                    tax_total.setText(total_tax.toString())

                } else {
                    cost_total.setText("");
                    tax_total.setText("");
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        tax.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val price_tax: Float
                val price: Float

                if (!cost.text.isNullOrEmpty() && !tax.text.isNullOrEmpty()) {
                    val price_tax = java.lang.Float.parseFloat(tax.text.toString())
                    val price = java.lang.Float.parseFloat(cost.text.toString())
                    val total_tax = price * price_tax / 100
                    val price_plus_tax = price + total_tax
                    cost_total.setText(price_plus_tax.toString())
                    tax_total.setText(total_tax.toString())

                } else {
                    cost_total.setText("");
                    tax_total.setText("");

                }


            }
            override fun afterTextChanged(s: Editable?) {
            }
        })


    }
}
