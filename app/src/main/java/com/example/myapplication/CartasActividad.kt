package com.example.myapplication

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CartasActividad:AppCompatActivity() {
    private lateinit var carta1: ImageView
    private lateinit var carta2: ImageView
    private lateinit var carta3: ImageView

    private val imagenesCarta = arrayOf(
        R.drawable.joker2,
        R.drawable.joker1,
        R.drawable.joker2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartas)

        carta1 = findViewById(R.id.imageViewCarta1)
        carta2 = findViewById(R.id.imageViewCarta2)
        carta3 = findViewById(R.id.imageViewCarta3)
    }

    fun voltearCarta(view: View) {
        val cartaSeleccionada = view as ImageView

        // Obtener el índice de la carta seleccionada
        val indice = when (cartaSeleccionada.id) {
            R.id.imageViewCarta1 -> 0
            R.id.imageViewCarta2 -> 1
            R.id.imageViewCarta3 -> 2
            else -> -1
        }


        val imagenCarta = imagenesCarta[indice]

        // Rotar la carta 180 grados
        val rotacion = ObjectAnimator.ofFloat(cartaSeleccionada, "rotationY", 0f, 180f)
        rotacion.duration = 500
        rotacion.start()


        Handler().postDelayed({
            cartaSeleccionada.setImageResource(imagenCarta)
        }, 250)


        Handler().postDelayed({

            val rotacionInversa = ObjectAnimator.ofFloat(cartaSeleccionada, "rotationY", 180f, 90f)
            rotacionInversa.duration = 500
            rotacionInversa.interpolator = AccelerateDecelerateInterpolator()
            rotacionInversa.start()


            Handler().postDelayed({
                cartaSeleccionada.setImageResource(R.drawable.dorso)


                val rotacionFinal = ObjectAnimator.ofFloat(cartaSeleccionada, "rotationY", 90f, 0f)
                rotacionFinal.duration = 500
                rotacionFinal.interpolator = AccelerateDecelerateInterpolator()
                rotacionFinal.start()
            }, 250)
        }, 1000)
    }
}