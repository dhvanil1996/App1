package com.example.sunny.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tips.*
import kotlinx.android.synthetic.main.activity_main.view.*
import android.widget.EditText
import android.widget.Button
import android.widget.CheckBox



class Tips : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        val result = compute
        val bill_input = Bill_Amount_Input
        val tip_input = Tip_Amount_Input
        val show_result = Price_Display
        val split_bill = Split_Bill

        val per_person = PerPerson
        val no_of_people = Persons
        val price_per_person = PricePerPerson

        per_person.visibility = View.INVISIBLE
        no_of_people.visibility = View.INVISIBLE
        price_per_person.visibility = View.INVISIBLE


        result.setOnClickListener {
                val bill_amount = (bill_input.text.toString()).toDouble()
                val tip_amount = (tip_input.text.toString()).toDouble()
                val total_amount = (bill_amount + (bill_amount * (tip_amount / 100)))

                show_result.setText(total_amount.toString())

        }
    }
}
