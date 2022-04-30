package com.example.coink

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val blogin = findViewById<View>(R.id.button) as Button
        blogin.setOnClickListener{
            val ventana = Intent(this, MovilActivity::class.java)
            startActivity(ventana)
        }

    }
}