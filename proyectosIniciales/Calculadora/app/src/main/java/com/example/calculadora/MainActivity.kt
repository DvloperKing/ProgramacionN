package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        // Función para obtener los números
        fun getNumbers(): Pair<Double, Double>? {
            val n1 = num1.text.toString().toDoubleOrNull()
            val n2 = num2.text.toString().toDoubleOrNull()

            if (n1 != null && n2 != null) {
                return Pair(n1, n2)
            } else {
                txtResultado.text = "Ingrese números válidos"
                return null
            }
        }

        // Eventos de los botones con corrección
        btnSumar.setOnClickListener {
            getNumbers()?.let { numbers ->
                txtResultado.text = "Resultado: ${numbers.first + numbers.second}"
            }
        }

        btnRestar.setOnClickListener {
            getNumbers()?.let { numbers ->
                txtResultado.text = "Resultado: ${numbers.first - numbers.second}"
            }
        }

        btnMultiplicar.setOnClickListener {
            getNumbers()?.let { numbers ->
                txtResultado.text = "Resultado: ${numbers.first * numbers.second}"
            }
        }

        btnDividir.setOnClickListener {
            getNumbers()?.let { numbers ->
                if (numbers.second != 0.0) {
                    txtResultado.text = "Resultado: ${numbers.first / numbers.second}"
                } else {
                    txtResultado.text = "No se puede dividir entre 0"
                }
            }
        }
    }
}
