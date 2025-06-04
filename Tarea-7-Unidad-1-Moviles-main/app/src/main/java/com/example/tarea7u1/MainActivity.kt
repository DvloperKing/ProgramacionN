// Línea 1: Define el paquete al que pertenece esta clase.
package com.example.tarea7u1

// Línea 2: Línea en blanco para separar la declaración del paquete de las importaciones.

// Línea 3: Importa Bundle, usado para pasar y restaurar el estado de la actividad.
// Línea 4: Importa ComponentActivity, la actividad base con soporte de Componentes Jetpack.
// Línea 5: Importa setContent, que permite definir la UI con Compose.
// Línea 6: Importa enableEdgeToEdge, para ocupar toda la pantalla sin bordes.
// Línea 7: Importa el modificador fillMaxSize, para que un componente llene todo el espacio.
// Línea 8: Importa el modificador padding, que añade espacio interior a un componente.
// Línea 9: Importa Scaffold, contenedor base de Material 3 para estructura de pantalla.
// Línea 10: Importa Text, componente para mostrar texto en Compose.
// Línea 11: Importa la anotación @Composable, marca funciones de UI.
// Línea 12: Importa Modifier, objeto para encadenar cambios de layout y estilo.
// Línea 13: Importa @Preview, para previsualizar composables en Android Studio.
// Línea 14: Importa el tema personalizado de la app.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tarea7u1.ui.theme.Tarea7u1Theme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

// Línea 15: Línea en blanco para separar las importaciones de la definición de la clase principal.

class MainActivity : ComponentActivity() { // Línea 16: Define MainActivity que hereda de ComponentActivity.
    override fun onCreate(savedInstanceState: Bundle?) { // Línea 17: Método llamado al crear la actividad.
        super.onCreate(savedInstanceState) // Línea 18: Inicializa la actividad padre.
        enableEdgeToEdge() // Línea 19: Activa el modo full-screen sin barras de sistema.
        setContent { // Línea 20: Inicio del bloque Compose para definir la UI.
            Tarea7u1Theme { // Línea 21: Aplica el tema de la app al contenido.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // Línea 22: Crea un Scaffold que ocupa toda la pantalla y provee padding interno.
                    Greeting( // Línea 23: Llama al composable Greeting.
                        name = "Fernando", // Línea 24: Pasa el parámetro name con valor "Android".
                        modifier = Modifier.padding(innerPadding) // Línea 25: Aplica el padding interno generado por el Scaffold.
                    ) // Línea 26: Cierra la llamada a Greeting.
                } // Línea 27: Cierra el contenido del Scaffold.
            } // Línea 28: Cierra el bloque del tema.
        } // Línea 29: Cierra el bloque setContent.
    } // Línea 30: Cierra el método onCreate.
} // Línea 31: Cierra la definición de MainActivity.

// Línea 32: Línea en blanco para separar la clase de las funciones composables.

@Composable // Línea 33: Anota la siguiente función como composable.
fun Greeting(name: String, modifier: Modifier = Modifier) { // Línea 34: Define Greeting, recibe name y un Modifier opcional.
    Text( // Línea 35: Componente Text para mostrar texto.
        text = "Hi, my name is $name!", // Línea 36: Interpola el nombre dentro del texto.
        modifier = modifier.padding(24.dp) // Línea 37: Aplica el Modifier recibido como parámetro.
    ) // Línea 38: Cierra la llamada a Text.
} // Línea 39: Cierra la función Greeting.

// Línea 40: Línea en blanco para separar Greeting de su vista previa.

@Preview(showBackground = true) // Línea 41: Anota la función para previsualizarla con fondo.
@Composable // Línea 42: Indica que la siguiente función es un composable.
fun GreetingPreview() { // Línea 43: Define la vista previa de Greeting.
    Tarea7u1Theme { // Línea 44: Aplica el tema de la app.
        Greeting("Android") // Línea 45: Llama a Greeting con "Android" para la preview.
    } // Línea 46: Cierra el bloque del tema.
} // Línea 47: Cierra la función GreetingPreview.