package com.example.coink

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MovilActivity : AppCompatActivity() {

    lateinit var movil: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movil)




        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val uno = findViewById<View>(R.id.button1) as Button
        val dos = findViewById<View>(R.id.button2) as Button
        val tres = findViewById<View>(R.id.button3) as Button
        val cuatro = findViewById<View>(R.id.button4) as Button
        val cinco = findViewById<View>(R.id.button5) as Button
        val seis = findViewById<View>(R.id.button6) as Button
        val siete = findViewById<View>(R.id.button7) as Button
        val ocho = findViewById<View>(R.id.button8) as Button
        val nueve = findViewById<View>(R.id.button9) as Button
        val borrar = findViewById<View>(R.id.button10) as Button
        val cero = findViewById<View>(R.id.button11) as Button
        val sig = findViewById<View>(R.id.button12) as Button



        val numero = findViewById<View>(R.id.editTextPhone) as EditText
        sig.setVisibility(View.INVISIBLE);



        val atras = findViewById<View>(R.id.imageView6) as ImageView
        atras.setOnClickListener {
            onBackPressed()
        }

        uno.setOnClickListener {

            movil = numero.text.toString() + "1"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }

        }
        dos.setOnClickListener {
            movil = numero.text.toString() + "2"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        tres.setOnClickListener {
            movil = numero.text.toString() + "3"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        cuatro.setOnClickListener {
            movil = numero.text.toString() + "4"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        cinco.setOnClickListener {
            movil = numero.text.toString() + "5"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        seis.setOnClickListener {
            movil = numero.text.toString() + "6"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        siete.setOnClickListener {
            movil = numero.text.toString() + "7"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        ocho.setOnClickListener {
            movil = numero.text.toString() + "8"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        nueve.setOnClickListener {
            movil = numero.text.toString() + "9"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }
        cero.setOnClickListener {
            movil = numero.text.toString() + "0"
            if(movil.length < 12)
                numero.setText(movil)
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(movil))
                sig.setVisibility(View.VISIBLE);
            if(Espacio(movil)){
                movil = numero.text.toString() + " "
                numero.setText(movil)
            }
        }

        borrar.setOnClickListener {
            val length: Int = numero.text.length
            if (length > 0) {
               numero.text.delete(length - 1, length)
            }
            sig.setVisibility(View.INVISIBLE);
            if(SiguientePaso(numero.text.toString()))
                sig.setVisibility(View.VISIBLE);
        }

        sig.setOnClickListener {

            Log.d(TAG, "El movil a resgistar es" + movil);
            val ventana = Intent(this, DatosActivity::class.java)
            startActivity(ventana)
        }

    }

    private fun SiguientePaso(x: String): Boolean {
        val length: Int = x.length
        var Rta: Boolean = false
        if (length >= 11)
            Rta =  true
        return Rta
    }

    private fun Espacio(x: String): Boolean {
        val length: Int = x.length
        var Rta: Boolean = false
        if (length == 3)
            Rta =  true
        return Rta
    }

    public fun numero_movil(): String {
        return movil;
    }


}