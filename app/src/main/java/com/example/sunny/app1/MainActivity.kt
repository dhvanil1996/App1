package com.example.sunny.app1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when user clicks Tips button **/
    fun tipsActivity(view : View) {
        val intent = Intent(this, Tips::class.java).apply{
        }
        startActivity(intent)
    }

    /** Called when user clicks Calculator button **/
    fun calcActivity(view: View){
        val intent = Intent(this, Calculator::class.java).apply{
        }
        startActivity(intent)
    }


    /** Called when user clicks Area button **/
    fun areaActivity(view: View){
        val intent = Intent(this, Area::class.java).apply{
        }
        startActivity(intent)
    }

    /** Called when user clicks Bmi button **/
    fun bmiActivity(view: View){
        val intent = Intent(this, BMI::class.java).apply{
        }
        startActivity(intent)
    }
}
