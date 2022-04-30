package com.example.coink

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class FinalizarActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val atras = findViewById<View>(R.id.imageView) as ImageView
        atras.setOnClickListener {
            onBackPressed()
        }

        val blogin = findViewById<View>(R.id.button13) as Button




        val Aceptar = findViewById<View>(R.id.checkBox3) as CheckBox
        Aceptar.setOnClickListener {

            if(Aceptar.isChecked){

                Aceptar.setChecked(true)
                blogin.setBackgroundResource(R.drawable.redondear)
                blogin.setTextColor(R.color.verde_1)
                blogin.isEnabled = true
            }
            else{

                Aceptar.setChecked(false)
                blogin.setBackgroundResource(R.drawable.redondear2)
                blogin.setTextColor(Color.WHITE)
                blogin.isEnabled = false
            }

        }



    }


}