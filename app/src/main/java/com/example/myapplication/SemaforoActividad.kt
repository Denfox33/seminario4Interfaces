package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SemaforoActividad :AppCompatActivity(){
    private lateinit var semaforo1ImageView: ImageView

    private val handler = Handler()
    private var currentState = 0 // 0: Verde, 1: Amarillo, 2: Rojo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semaforo)

        semaforo1ImageView = findViewById(R.id.semaforo)


        // Inicia el temporizador
        startTimer()
    }

    private fun startTimer() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Cambia la imagen según el estado actual
                when (currentState) {
                    0 -> { // Verde

                        semaforo1ImageView.setImageResource(R.drawable.verde)
                        currentState = 1 // Cambia a Amarillo
                        handler.postDelayed(this, 2000) // 2 segundos en verde
                    }
                    1 -> { // Amarillo
                        semaforo1ImageView.setImageResource(R.drawable.amarillo)

                        currentState = 2 // Cambia a Rojo
                        handler.postDelayed(this, 1000) // 1 segundo en amarillo
                    }
                    2 -> { // Rojo
                        semaforo1ImageView.setImageResource(R.drawable.rojo)

                        currentState = 0 // Cambia a Verde
                        handler.postDelayed(this, 2000) // 2 segundos en rojo
                    }
                }
            }
        }, 2000) // Inicia con 2 segundos en verde
    }

    override fun onDestroy() {
        super.onDestroy()
        // Detiene el temporizador cuando la actividad se destruye
        handler.removeCallbacksAndMessages(null)
    }
}