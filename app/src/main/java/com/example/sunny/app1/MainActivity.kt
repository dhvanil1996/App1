package com.example.dweav.app1part2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), TextWatcher  { // change class name to the name of the calculator

    var shapes = arrayOf("Cube", "Sphere", "Cone")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setTitle("Surface Area of a Cube")

        setContentView(R.layout.activity_main)

        var adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)

        with(ShapesSpinner){
            adapter = adapt
            setSelection(0, false)

        }

        ShapesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (position == 1){
                    startActivity( Intent(this@MainActivity, SphereActivity::class.java) )
                }

                if (position == 2){
                    startActivity( Intent(this@MainActivity, ConeActivity::class.java) )
                }

                else{}
            }

        }

        val lengthView = findViewById<EditText>(R.id.RadiusEdit) as? EditText;
        val widthView = findViewById<EditText>(R.id.HeightEdit) as? EditText;
        val heightView = findViewById<EditText>(R.id.HeightView) as? EditText;

        val oneDecimal = DecimalFormat("#.#") // from https://www.programiz.com/kotlin-programming/examples/round-number-decimal

        val answerView = findViewById<TextView>(R.id.AnswerView) as? TextView;

        lengthView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {

                if (!lengthView?.text.isNullOrEmpty() && !widthView?.text.isNullOrEmpty() && !heightView?.text.isNullOrEmpty()) {
                    if (Integer.parseInt(lengthView?.text.toString()) > 0) {

                        val answer = java.lang.Float.parseFloat(lengthView.text.toString()) * java.lang.Float.parseFloat(widthView?.text.toString()) * java.lang.Float.parseFloat(heightView?.text.toString())

                        val answer_decimal = oneDecimal.format(answer);

                        answerView?.setText(answer_decimal + " Area Cubed");

                    }
                } else
                    answerView?.text = "0 Area Cubed"
            }
        })

        widthView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

                if (!lengthView?.text.isNullOrEmpty() && !widthView?.text.isNullOrEmpty() && !heightView?.text.isNullOrEmpty()) {
                    if (Integer.parseInt(lengthView?.text.toString()) > 0) {

                        val answer = java.lang.Float.parseFloat(lengthView?.text.toString()) * java.lang.Float.parseFloat(widthView?.text.toString()) * java.lang.Float.parseFloat(heightView?.text.toString())

                        val answer_decimal = oneDecimal.format(answer);

                        answerView?.setText(answer_decimal + " Area Cubed");

                    }
                } else
                    answerView?.text = "0 Area Cubed"
            }
        })

        heightView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

                if (!lengthView?.text.isNullOrEmpty() && !widthView?.text.isNullOrEmpty() && !heightView?.text.isNullOrEmpty()) {
                    if (Integer.parseInt(lengthView?.text.toString()) > 0) {

                        val answer = java.lang.Float.parseFloat(lengthView?.text.toString()) * java.lang.Float.parseFloat(widthView?.text.toString()) * java.lang.Float.parseFloat(heightView.text.toString())

                        val answer_decimal = oneDecimal.format(answer);

                        answerView?.setText(answer_decimal + " Area Cubed");

                    }
                } else
                    answerView?.text = "0 Area Sq."
            }
        })
    } // end of override OnCreate


    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable) {

    }
}
