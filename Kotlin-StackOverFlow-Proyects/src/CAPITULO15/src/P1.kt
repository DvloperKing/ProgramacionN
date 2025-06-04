/**
 * Capítulo 15: Extensiones Kotlin para Android
 *
 * Este programa muestra el uso de las Kotlin Android Extensions, una característica que permite
 * acceder a vistas en layouts de forma directa, sin usar findViewById().
 *
 * ✔️ Ventajas:
 * - Mejor sintaxis
 * - Mejor tipado estático
 * - Menos propenso a errores
 *
 * El uso está limitado a clases con vistas infladas (Actividades, Fragmentos, Vistas).
 */

package com.example.kextdemo

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import kotlinx.android.synthetic.main.activity_main.* // Importa todas las vistas del layout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carga el diseño definido en res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // Acceso directo al botón definido en el layout (sin findViewById)
        my_button.text = "¡Kotlin lo hace fácil!"

        // Ejecutar algo cuando la vista ya esté completamente dibujada
        my_button.afterMeasured {
            println("Botón medido: ancho=${it.width}, alto=${it.height}")
        }
    }
}

// ====================================================
// Extensión útil: Ejecuta código cuando una vista ya fue dibujada
// ====================================================
inline fun View.afterMeasured(crossinline f: View.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredHeight > 0 && measuredWidth > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}
