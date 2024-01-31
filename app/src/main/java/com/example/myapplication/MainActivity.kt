package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var botonActividad1: Button
    private lateinit var botonActividad2: Button
    private lateinit var botonActividad3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar los botones
        botonActividad1 = findViewById(R.id.botonActividad1)
        botonActividad2 = findViewById(R.id.botonActividad2)
        botonActividad3 = findViewById(R.id.botonActividad3)

        // Configurar listeners para los botones
        botonActividad1.setOnClickListener {
            startActivity(Intent(this, Contardor1::class.java))
        }

        botonActividad2.setOnClickListener {
            startActivity(Intent(this, CartasActividad::class.java))
        }

        botonActividad3.setOnClickListener {
            startActivity(Intent(this, SemaforoActividad::class.java))
        }
    }
}