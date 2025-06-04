import java.text.DecimalFormat

// -------------------------
// Ejemplo 1: Extensión para IntArray
// -------------------------
fun IntArray.addTo(dest: IntArray) {
    for (i in 0 until this.size) {
        dest[i] += this[i]
    }
}

// -------------------------
// Ejemplo 2: Extensiones estáticas y resolución estática
// -------------------------
open class Super
class Sub : Super()

fun Super.myExtension() = "Definido para Super"
fun Sub.myExtension() = "Definido para Sub"

fun callMyExtension(myVar: Super) {
    println(myVar.myExtension())  // Siempre llamará a la versión de Super
}

// -------------------------
// Ejemplo 3: Extensiones para formato humanReadable (Int y Long)
// -------------------------
fun Long.humanReadable(): String {
    if (this <= 0) return "0"
    val units = arrayOf("B", "KB", "MB", "GB", "TB", "EB")
    val digitGroups = (Math.log10(this.toDouble()) / Math.log10(1024.0)).toInt()
    return DecimalFormat("#,##0.#").format(this / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
}

fun Int.humanReadable(): String = this.toLong().humanReadable()

// -------------------------
// Ejemplo 5: Función de extensión para validación con lambdas
// -------------------------
infix inline fun <T> T.verifiedBy(verifyWith: (T) -> Unit): T {
    verifyWith(this)
    return this
}

infix inline fun <T : Any> T.verifiedWith(verifyWith: T.() -> Unit): T {
    this.verifyWith()
    return this
}

// -------------------------
// Ejemplo 7: Extensiones para companion objects (simulación)
// -------------------------
class Something {
    companion object {}
}

class SomethingElse

fun Something.Companion.fromString(s: String): Something {
    println("Creando Something desde String: $s")
    return Something()
}

fun SomethingElse.fromString(s: String): SomethingElse {
    println("Creando SomethingElse desde String: $s")
    return SomethingElse()
}

// -------------------------
// Ejemplo 8: Propiedad de extensión con caché
// -------------------------
class KColor(val value: Int)
class Color(val value: Int, val flag: Boolean)

private val colorCache = mutableMapOf<KColor, Color>()

val KColor.color: Color
    get() = colorCache.getOrPut(this) { Color(this.value, true) }

// -------------------------
// Ejemplo 9: Simulación de clases View y extensión find con cast seguro
// -------------------------
open class View(val id: Int) {
    fun findViewById(id: Int): View? {
        println("Buscando View con id: $id")
        return View(id)
    }
}

inline fun <reified T : View> View.find(id: Int): T? = findViewById(id) as? T

// -------------------------
// MAIN para probar todo
// -------------------------
fun main() {
    // Ejemplo 1
    val arr1 = intArrayOf(1, 2, 3)
    val arr2 = intArrayOf(4, 5, 6)
    arr1.addTo(arr2)
    println("Ejemplo 1: arr2 después de addTo: ${arr2.joinToString()}")

    // Ejemplo 2
    val sub = Sub()
    callMyExtension(sub)  // Imprime "Definido para Super"

    // Ejemplo 3
    println("Ejemplo 3: 1999549L humanReadable: ${1999549L.humanReadable()}")
    println("Ejemplo 3: 2048 humanReadable: ${2048.humanReadable()}")

    // Ejemplo 5
    val num = 10 verifiedBy {
        require(it > 5) { "El número debe ser mayor que 5" }
    }
    println("Ejemplo 5: Número verificado $num")

    // Ejemplo 7
    Something.fromString("Hola")
    val se = SomethingElse().fromString("Adiós")

    // Ejemplo 8
    val kColor = KColor(123)
    println("Ejemplo 8: Color cacheado: ${kColor.color}")

    // Ejemplo 9
    val rootView = View(0)
    val foundView: View? = rootView.find(100)
    println("Ejemplo 9: Found View id = ${foundView?.id}")
}
