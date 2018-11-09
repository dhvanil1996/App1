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

        var box_checked: Boolean? = null

        split_bill.setOnClickListener {
            if (split_bill.isChecked) {
                per_person.visibility = View.VISIBLE
                no_of_people.visibility = View.VISIBLE
                price_per_person.visibility = View.VISIBLE
                box_checked = true
            } else {
                per_person.visibility = View.INVISIBLE
                no_of_people.visibility = View.INVISIBLE
                price_per_person.visibility = View.INVISIBLE
                box_checked = false
            }
        }



        result.setOnClickListener {
            if (box_checked == true) {
                val bill_amount: Double
                val tip_amount: Double
                val total_amount: Double
                val people: Double
                val individual_price: Double

                if (!bill_input.text.isNullOrEmpty() && !tip_input.text.isNullOrEmpty() && !no_of_people.text.isNullOrEmpty()) {

                    bill_amount = (bill_input.text.toString()).toDouble()
                    tip_amount = (tip_input.text.toString()).toDouble()
                    total_amount = (bill_amount + (bill_amount * (tip_amount / 100)))
                    people = no_of_people.text.toString().toDouble()
                    individual_price = total_amount / people
                    per_person.setText(individual_price.toString())
                    show_result.setText(total_amount.toString())
                } else if (!bill_input.text.isNullOrEmpty() && tip_input.text.isNullOrEmpty() && !no_of_people.text.isNullOrEmpty()) {
                    bill_amount = (bill_input.text.toString()).toDouble()
                    people = no_of_people.text.toString().toDouble()
                    individual_price = bill_amount / people
                    per_person.setText(individual_price.toString())
                    show_result.setText(bill_amount.toString())
                } else if (!bill_input.text.isNullOrEmpty() && !tip_input.text.isNullOrEmpty() && no_of_people.text.isNullOrEmpty()) {
                    bill_amount = (bill_input.text.toString()).toDouble()
                    tip_amount = (tip_input.text.toString()).toDouble()
                    total_amount = (bill_amount + (bill_amount * (tip_amount / 100)))
                    show_result.setText(total_amount.toString())
                    per_person.setText("")
                } else {
                    show_result.setText("")
                    per_person.setText("")
                }

            } else if (box_checked == false || box_checked == null) {
                if (!bill_input.text.isNullOrEmpty()) {
                    val bill_amount = (bill_input.text.toString()).toDouble()
                    if (!tip_input.text.isNullOrEmpty()) {
                        val tip_amount = (tip_input.text.toString()).toDouble()
                        val total_amount = (bill_amount + (bill_amount * (tip_amount / 100)))
                        show_result.setText(total_amount.toString())
                    } else {
                        show_result.setText(bill_amount.toString())
                    }
                } else {
                    show_result.setText("")
                }

            }


        }

    }
}

