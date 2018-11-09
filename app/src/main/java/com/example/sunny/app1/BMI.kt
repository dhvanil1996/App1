package com.example.dweav.app1part2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.pow

class BMIActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setTitle("Body Mass Index Calculator")

        setContentView(R.layout.bmi_activity)

        val heightFeetView = findViewById<EditText>(R.id.HeightFeetView) as? EditText;
        val heightInchesView = findViewById<EditText>(R.id.HeightInchesView) as? EditText;
        val weightPoundsView = findViewById<EditText>(R.id.WeightPoundsView) as? EditText;

        val bMIView = findViewById<TextView>(R.id.BMIView) as? TextView;

        val oneDecimal = DecimalFormat("#.#") // from https://www.programiz.com/kotlin-programming/examples/round-number-decimal

        heightFeetView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {

                if (!heightFeetView?.text.isNullOrEmpty()
                    && !heightInchesView?.text.isNullOrEmpty()
                    && !weightPoundsView?.text.isNullOrEmpty()
                    && java.lang.Integer.parseInt(heightInchesView?.text.toString()) < 12) {

                    if (Integer.parseInt(heightFeetView?.text.toString()) > 0) {

                        val inches = java.lang.Float.parseFloat(heightFeetView?.text.toString()) * 12 + java.lang.Integer.parseInt(heightInchesView?.text.toString())

                        val answer = 703 * java.lang.Float.parseFloat(weightPoundsView?.text.toString()) / inches.pow(2);

                        val answer_decimal = oneDecimal.format(answer);

                        bMIView?.setText(answer_decimal);

                    }

                }

                else if(!heightInchesView?.text.isNullOrEmpty() && java.lang.Integer.parseInt(heightInchesView?.text.toString()) >= 12){
                    bMIView?.text = "Inches input must be less than 12"
                }

                else
                    bMIView?.text = "BMI"
            }
        })

        heightInchesView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {

                if (!heightFeetView?.text.isNullOrEmpty()
                    && !heightInchesView?.text.isNullOrEmpty()
                    && !weightPoundsView?.text.isNullOrEmpty()
                    && java.lang.Integer.parseInt(heightInchesView?.text.toString()) < 12) {

                    if (Integer.parseInt(heightInchesView?.text.toString()) > 0) {

                        val inches = java.lang.Float.parseFloat(heightFeetView?.text.toString()) * 12 + java.lang.Integer.parseInt(heightInchesView?.text.toString())

                        val answer = 703 * java.lang.Float.parseFloat(weightPoundsView?.text.toString()) / inches.pow(2);

                        val answer_decimal = oneDecimal.format(answer);

                        bMIView?.setText(answer_decimal);

                    }

                }

                else if(!heightInchesView?.text.isNullOrEmpty() && java.lang.Integer.parseInt(heightInchesView?.text.toString()) >= 12){
                    bMIView?.text = "Inches input must be less than 12"
                }

                else
                    bMIView?.text = "BMI"
            }
        })

        weightPoundsView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

                if (!heightFeetView?.text.isNullOrEmpty()
                    && !heightInchesView?.text.isNullOrEmpty()
                    && !weightPoundsView?.text.isNullOrEmpty()
                    && java.lang.Integer.parseInt(heightInchesView?.text.toString()) < 12) {

                    if (Integer.parseInt(weightPoundsView?.text.toString()) > 0) {

                        val inches = java.lang.Float.parseFloat(heightFeetView?.text.toString()) * 12 + java.lang.Integer.parseInt(heightInchesView?.text.toString())

                        val answer = 703 * java.lang.Float.parseFloat(weightPoundsView?.text.toString()) / inches.pow(2);

                        val answer_decimal = oneDecimal.format(answer);

                        bMIView?.setText(answer_decimal);

                    }

                }

                else if(!heightInchesView?.text.isNullOrEmpty() && java.lang.Integer.parseInt(heightInchesView?.text.toString()) >= 12){
                    bMIView?.text = "Inches input must be less than 12"
                }

                else
                    bMIView?.text = "BMI"
            }
        })

    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable) {

    }
}