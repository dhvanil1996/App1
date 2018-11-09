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
import kotlin.math.PI
import kotlin.math.pow

class ConeActivity : AppCompatActivity(), TextWatcher  { // change class name to the name of the calculator

    var shapes = arrayOf("Cube", "Sphere", "Cone")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setTitle("Surface Area of a Cone")

        setContentView(R.layout.cone_activity)

        var adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)

        with(ShapesSpinner){
            adapter = adapt
            setSelection(2, false)

        }

        ShapesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (position == 0){
                    startActivity( Intent(this@ConeActivity, MainActivity::class.java) )
                }

                if (position == 1){
                    startActivity( Intent(this@ConeActivity, SphereActivity::class.java) )
                }

                else{}
            }

        }

        val radiusEdit = findViewById<EditText>(R.id.RadiusEdit) as? EditText;
        val heightEdit = findViewById<EditText>(R.id.HeightEdit) as? EditText;

        val oneDecimal = DecimalFormat("#.#") // from https://www.programiz.com/kotlin-programming/examples/round-number-decimal

        val answerView = findViewById<TextView>(R.id.AnswerView) as? TextView;

        radiusEdit?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {

                if (!radiusEdit?.text.isNullOrEmpty() && !heightEdit?.text.isNullOrEmpty()) {
                    if (java.lang.Float.parseFloat(radiusEdit?.text.toString()) > 0) {

                        val answer = PI * java.lang.Float.parseFloat(radiusEdit?.text.toString()) *
                                (
                                        java.lang.Float.parseFloat(radiusEdit?.text.toString())
                                        +       java.lang.Float.parseFloat(radiusEdit?.text.toString()).pow(2)
                                        +       java.lang.Float.parseFloat(heightEdit?.text.toString()).pow(2)
                                        )
                            //πr2h

                        val answer_decimal = oneDecimal.format(answer);

                        answerView?.setText(answer_decimal + " Units Cubed");

                    }
                } else
                    answerView?.text = "0 Units Cubed"
            }
        })

        heightEdit?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

                if (!radiusEdit?.text.isNullOrEmpty() && !heightEdit?.text.isNullOrEmpty()) {
                    if (java.lang.Float.parseFloat(heightEdit?.text.toString()) > 0) {

                        val answer = PI * java.lang.Float.parseFloat(radiusEdit?.text.toString()) *
                                (
                                        java.lang.Float.parseFloat(radiusEdit?.text.toString())
                                                +       java.lang.Float.parseFloat(radiusEdit?.text.toString()).pow(2)
                                                +       java.lang.Float.parseFloat(heightEdit?.text.toString()).pow(2)
                                        )
                        //A=πr(r+h2+r2)

                        val answer_decimal = oneDecimal.format(answer);

                        answerView?.setText(answer_decimal + " Units Cubed");

                    }
                } else
                    answerView?.text = "0 Units Cubed"
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
