package com.example.mod3demo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tvHello)
        val et = findViewById<EditText>(R.id.etName)
        val btn = findViewById<Button>(R.id.btnGo)

        //ajout d'un évènement sur le bouton
        btn.setOnClickListener {
            //récupération du text de l'input
            val text = et.text.toString()
            //affichage dans le textview
            tv.text = "Hello $text !"
        }



    }
}