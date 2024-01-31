package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Contardor1:AppCompatActivity() {

    private lateinit var textViewCuentaAtras: TextView
    private lateinit var imageViewExplosion: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        textViewCuentaAtras = findViewById(R.id.textViewCuentaAtras)
        imageViewExplosion = findViewById(R.id.img_explosion)

        object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val segundosRestantes = millisUntilFinished / 1000
                textViewCuentaAtras.text = segundosRestantes.toString()


                if (segundosRestantes == 0L) {
                    mostrarExplosion()
                }
            }

            override fun onFinish() {

            }
        }.start()
    }

    private fun mostrarExplosion() {
        textViewCuentaAtras.visibility = TextView.INVISIBLE
        imageViewExplosion.visibility = ImageView.VISIBLE
         }
}