// Tema: Anotaciones en Kotlin
// Este código muestra cómo declarar una anotación personalizada con meta-anotaciones.

// @Target especifica los elementos del código que pueden estar anotados con esta anotación.
// En este caso, puede usarse en clases, funciones, parámetros y expresiones.
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)

// @Retention especifica que esta anotación solo estará disponible en el código fuente,
// pero no se conservará en el bytecode ni estará disponible en tiempo de ejecución.
@Retention(AnnotationRetention.SOURCE)

// @MustBeDocumented indica que esta anotación aparecerá en la documentación generada.
@MustBeDocumented

// Declaración de la anotación llamada Fancy sin parámetros.
annotation class Fancy

// Uso de la anotación en una clase
@Fancy
class MiClaseAnotada {

    // Uso de la anotación en una función
    @Fancy
    fun funcionAnotada() {
        println("Función anotada con @Fancy")
    }
}

fun main() {
    val objeto = MiClaseAnotada()
    objeto.funcionAnotada()
}
