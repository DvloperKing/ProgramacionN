class Vehiculo {
    var marca: String
    var modelo: String

    constructor(marca: String, modelo: String) {
        this.marca = marca
        this.modelo = modelo
    }
}

fun main() {
    val coche = Vehiculo("Toyota", "Corolla")
    println("Vehículo: ${coche.marca} ${coche.modelo}")
}