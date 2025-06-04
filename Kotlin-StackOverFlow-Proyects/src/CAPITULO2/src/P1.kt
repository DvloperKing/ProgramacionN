// Simulación de una clase de vista con un campo de texto anulable
class TextField(var text: String?)
class View(var textField: TextField?)

fun main() {
    // CASO 1: Campo de texto presente con texto válido
    val view1 = View(TextField("Hola Karla"))

    // ❌ Forma incorrecta: toString() se llama fuera del ámbito de seguridad null
    val incorrect1 = view1.textField?.text.toString() ?: ""
    println("Incorrecto 1: $incorrect1")  // Salida: Hola Karla

    // ✅ Forma correcta
    val correct1 = view1.textField?.text?.toString() ?: ""
    println("Correcto 1: $correct1")  // Salida: Hola Karla


    // CASO 2: Campo de texto es null
    val view2 = View(null)

    val incorrect2 = view2.textField?.text.toString() ?: ""
    println("Incorrecto 2: $incorrect2")  // ⚠️ Salida: "null" (como string)

    val correct2 = view2.textField?.text?.toString() ?: ""
    println("Correcto 2: $correct2")  // ✅ Salida: "" (cadena vacía)
}
