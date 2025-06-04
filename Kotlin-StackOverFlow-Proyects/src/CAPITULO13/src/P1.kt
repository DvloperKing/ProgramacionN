// Capítulo 13: Equivalentes de flujo de Java 8 en Kotlin
// Este programa demuestra cómo Kotlin realiza operaciones estilo funcional como en Java 8 usando Sequences y Collections.

fun main() {

    println("== Acumular nombres en una lista ==")
    val people = listOf(Person("Ana", 25), Person("Luis", 35), Person("María", 28))
    val list = people.map { it.name } // Extrae los nombres de las personas
    println(list)

    println("\n== Convertir elementos en cadenas y concatenarlos ==")
    val things = listOf(1, 2, 3)
    val joined = things.joinToString() // Une los elementos como cadena separados por coma
    println(joined)

    println("\n== Calcular suma de salarios ==")
    val employees = listOf(Employee("A", 1000), Employee("B", 2000), Employee("C", 1500))
    val totalSalary = employees.sumOf { it.salary } // Suma todos los salarios
    println(totalSalary)

    println("\n== Agrupar empleados por departamento ==")
    val empDept = listOf(
        Employee("Ana", 1000, "Ventas"),
        Employee("Luis", 2000, "IT"),
        Employee("Carla", 1500, "Ventas")
    )
    val byDept = empDept.groupBy { it.dept } // Agrupa por departamento
    println(byDept)

    println("\n== Sumar salarios por departamento ==")
    val totalByDept = empDept.groupBy { it.dept }
        .mapValues { it.value.sumOf { emp -> emp.salary } } // Suma salarios por grupo
    println(totalByDept)

    println("\n== Particionar estudiantes entre aprobados y reprobados ==")
    val students = listOf(Student("Pedro", 70), Student("Ana", 40))
    val passingFailing = students.partition { it.grade >= 60 } // Separa por condición de aprobación
    println(passingFailing)

    println("\n== Filtrar nombres masculinos ==")
    val roster = listOf(
        Person("Pedro", 20, Person.Sex.MALE),
        Person("Laura", 22, Person.Sex.FEMALE)
    )
    val namesOfMaleMembers = roster
        .filter { it.gender == Person.Sex.MALE }
        .map { it.name } // Filtra hombres y extrae nombre
    println(namesOfMaleMembers)

    println("\n== Agrupar nombres por género ==")
    val namesByGender = roster.groupBy { it.gender }.mapValues { it.value.map { it.name } }
    println(namesByGender)

    println("\n== Filtrar una lista por elementos que empiezan con 'o' ==")
    val items = listOf("oso", "tigre", "orca", "mono")
    val filtered = items.filter { it.startsWith('o') } // Filtra palabras que empiezan con 'o'
    println(filtered)

    println("\n== Encontrar la cadena más corta ==")
    val shortest = items.minByOrNull { it.length } // Encuentra la palabra más corta
    println(shortest)

    println("\n== Usar perezosamente el primer elemento ==")
    sequenceOf("a1", "a2", "a3").firstOrNull()?.apply(::println) // Toma el primero, si existe

    println("\n== Iterar un rango de enteros ==")
    (1..3).forEach(::println) // Imprime 1, 2, 3

    println("\n== Mapear valores y calcular promedio ==")
    val avg = arrayOf(1, 2, 3).map { 2 * it + 1 }.average() // Aplica función y promedia
    println(avg)

    println("\n== Convertir strings a int y encontrar el máximo ==")
    sequenceOf("a1", "a2", "a3")
        .map { it.substring(1) } // Elimina la letra 'a'
        .map(String::toInt)      // Convierte a número
        .maxOrNull()             // Busca el máximo
        .apply(::println)

    println("\n== Mapear rango a strings y mostrar ==")
    (1..3).map { "a$it" }.forEach(::println) // Mapea 1..3 a "a1", "a2", "a3"

    println("\n== Iterar doubles, mapear a int, luego a string ==")
    sequenceOf(1.0, 2.0, 3.0)
        .map(Double::toInt)   // Convierte a entero
        .map { "a$it" }       // Mapea a "a1", "a2", "a3"
        .forEach(::println)

    println("\n== Contar cuántos elementos empiezan con 't' ==")
    val count = items.count { it.startsWith('t') } // Cuenta los que comienzan con 't'
    println(count)

    println("\n== Filtrar, convertir a mayúsculas y ordenar ==")
    val lista = listOf("a1", "a2", "b1", "c2", "c1")
    lista.filter { it.startsWith('c') }
        .map { it.uppercase() }  // Cambiado a uppercase() moderno
        .sorted()
        .forEach(::println)

    println("\n== Usar operador ?. y función apply con una extensión personalizada ==")
    listOf("a1", "a2", "a3").firstOrNull().ifPresent(::println) // Ejecuta acción si no es nulo
}

// Clases auxiliares para el ejemplo
data class Person(val name: String, val age: Int, val gender: Sex = Sex.OTHER) {
    enum class Sex { MALE, FEMALE, OTHER }
}

data class Employee(val name: String, val salary: Int, val dept: String = "General")

data class Student(val name: String, val grade: Int)

// Extensión personalizada: ejecuta un bloque si el String no es nulo
inline fun String?.ifPresent(thenDo: (String) -> Unit) = this?.apply { thenDo(this) }
