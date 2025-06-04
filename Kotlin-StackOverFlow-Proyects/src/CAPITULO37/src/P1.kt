// Alias para un tipo de función que recibe un String y devuelve un Boolean
typealias StringValidator = (String) -> Boolean

// Alias genérico para un tipo de función que recibe dos parámetros y devuelve un valor
typealias Reductor<T, U, V> = (T, U) -> V

// Clase simple para representar una persona con un nombre
class Person(val name: String)

// Alias para un par de objetos Person (por ejemplo, los padres)
typealias Parents = Pair<Person, Person>

// Clase simple para representar una cuenta con ID y balance
class Account(val id: Int, val balance: Double)

// Alias para una lista de cuentas
typealias Accounts = List<Account>

fun main() {
    // Usamos el alias StringValidator para definir una función que valida si un String no está vacío
    val isNotEmpty: StringValidator = { input -> input.isNotEmpty() }

    // Probamos la función isNotEmpty con dos ejemplos
    println(isNotEmpty("Hola"))  // Imprime: true porque "Hola" no está vacío
    println(isNotEmpty(""))      // Imprime: false porque la cadena está vacía

    // Usamos el alias genérico Reductor para crear una función que suma dos enteros
    val sum: Reductor<Int, Int, Int> = { a, b -> a + b }

    // Probamos la función sumando 5 + 7
    println(sum(5, 7))  // Imprime: 12

    // Creamos un par de personas usando el alias Parents
    val parents: Parents = Pair(Person("Juan"), Person("Maria"))

    // Imprimimos los nombres de las personas en el par
    println("Padres: ${parents.first.name} y ${parents.second.name}")

    // Creamos una lista de cuentas usando el alias Accounts
    val accounts: Accounts = listOf(Account(1, 1000.0), Account(2, 2500.5))

    // Imprimimos cuántas cuentas hay en la lista
    println("Número de cuentas: ${accounts.size}")

    // Iteramos sobre la lista de cuentas e imprimimos su ID y balance
    accounts.forEach { account ->
        println("Cuenta ID: ${account.id}, Balance: ${account.balance}")
    }
}
