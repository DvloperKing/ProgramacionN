import java.io.Serializable
import java.io.File

// Data class que representa un usuario con propiedades firstname, lastname y age.
// Tiene valores por defecto para cada propiedad.
data class User(var firstname: String = "Joe", var lastname: String = "Bloggs", var age: Int = 20)

// Función que crea una lista de números y filtra solo los pares,
// luego imprime los números pares encontrados.
fun filtrarPares() {
    val list = listOf(1, 2, 3, 4, 5, 6)              // Lista de números enteros
    val even = list.filter { it % 2 == 0 }           // Filtra elementos pares usando lambda
    println("Números pares: $even")                   // Imprime la lista filtrada
}

// Interfaz genérica para una tabla con dos claves (K, V) y un valor (T)
// Define métodos para insertar (put) y obtener (get) valores.
interface Table<K, V, T> {
    fun put(key1: K, key2: V, value: T)              // Inserta un valor con dos claves
    fun get(key1: K, key2: V): T?                     // Obtiene un valor según las dos claves
}

// Implementación sencilla de la interfaz Table usando un mapa con pares como claves
class TreeBasedTable<K, V, T> : Table<K, V, T> {
    private val map = mutableMapOf<Pair<K, V>, T>()   // Mapa que almacena pares de claves y valores

    override fun put(key1: K, key2: V, value: T) {
        map[Pair(key1, key2)] = value                 // Inserta el valor en el mapa usando una pareja como clave
    }

    override fun get(key1: K, key2: V): T? = map[Pair(key1, key2)] // Obtiene el valor dado dos claves
}

// Clase que delega la funcionalidad de Table a otra instancia interna,
// la cual se oculta mediante constructor privado.
// Proporciona un constructor público sin parámetros que crea la instancia interna.
class MyTable private constructor(table: Table<Int, Int, Int>) : Table<Int, Int, Int> by table {
    constructor() : this(TreeBasedTable())             // Constructor público que crea TreeBasedTable
}

// Clase serializable que incluye un serialVersionUID para control de versión en serialización.
class MySpecialCase : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123L // Identificador único para serialización
    }
}

// Función de extensión genérica que permite ejecutar un bloque de código sobre un objeto
// y devuelve el mismo objeto, facilitando el encadenamiento de métodos (fluidez).
fun <T : Any> T.fluently(func: () -> Unit): T {
    func()               // Ejecuta el bloque de código pasado como parámetro
    return this          // Devuelve el objeto receptor para encadenar llamadas
}

// Clase de ejemplo que usa la función fluida para ejecutar una acción y devolver this.
class SomeClass {
    fun someOtherAction() {
        println("Haciendo otra acción...")             // Acción que imprime un mensaje
    }

    fun doSomething(): SomeClass {
        return fluently { someOtherAction() }          // Llama a someOtherAction y devuelve la instancia
    }
}

// Función que ejemplifica el uso de 'let' para ejecutar código solo si el objeto no es null.
fun ejemploLet() {
    val str: String? = "foo"                           // Variable nullable con valor
    str?.let {
        println("Let: $it")                            // Se ejecuta solo si str no es null
    }
    val nullStr: String? = null                         // Variable nullable con valor null
    nullStr?.let {
        println("Esto no se imprime porque es null")  // No se ejecuta porque nullStr es null
    }
}

// Función que ejemplifica el uso de 'apply' para configurar un objeto en un bloque
// y luego devolver el mismo objeto.
fun ejemploApply() {
    val dir = "miDirectorio"                           // Nombre del directorio a crear
    val file = File(dir).apply {                       // Crea un objeto File y ejecuta el bloque apply
        mkdirs()                                       // Crea el directorio y carpetas necesarias
        println("Directorio creado: $dir")             // Imprime mensaje confirmando creación
    }
}

// Función principal que ejecuta todas las pruebas y ejemplos anteriores.
fun main() {
    val user = User(age = 30)                          // Crea un objeto User con edad 30
    println("Usuario: $user")                          // Imprime la información del usuario

    filtrarPares()                                     // Llama a función para filtrar e imprimir pares

    val myTable = MyTable()                            // Crea una instancia de MyTable
    myTable.put(1, 1, 100)                             // Inserta el valor 100 con claves (1,1)
    println("Valor en tabla: ${myTable.get(1, 1)}")   // Obtiene e imprime el valor almacenado

    val specialCase = MySpecialCase()                  // Crea instancia de clase serializable
    println("Clase serializable creada: $specialCase")// Imprime referencia al objeto creado

    val someClass = SomeClass()                         // Crea instancia de SomeClass
    someClass.doSomething()                             // Ejecuta método con llamada fluida

    ejemploLet()                                       // Ejecuta ejemplo con let
    ejemploApply()                                     // Ejecuta ejemplo con apply
}
