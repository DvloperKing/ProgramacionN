// Tema: Interfaces en Kotlin y resolución de conflictos de métodos

// Definimos la primera interfaz con métodos abstractos y con implementación por defecto
interface FirstTrait {
    fun notImplemented()               // Método abstracto, sin implementación (debe implementarse)
    fun implementedOnlyInA() {         // Método con implementación por defecto
        print("only A\n")
    }
    fun implementedInBoth() {           // Método con implementación que existe en ambas interfaces
        print("both, A\n")
    }
    fun implementedInOne() {            // Método con implementación por defecto
        print("implemented in A\n")
    }
    fun bar()                          // Método abstracto, sin implementación
}

// Definimos la segunda interfaz con métodos, algunos con implementación por defecto
interface SecondTrait {
    fun implementedInBoth() {          // Método con implementación, igual que en FirstTrait (conflicto)
        print("both, B\n")
    }
    fun implementedInOne()             // Método abstracto (sin implementación)
    fun bar() {                       // Método con implementación por defecto
        print("bar from SecondTrait\n")
    }
}

// Clase que implementa ambas interfaces y debe resolver los conflictos de métodos
class ClassWithConflict : FirstTrait, SecondTrait {

    // Implementamos método abstracto de FirstTrait
    override fun notImplemented() {
        print("Normal implementation\n")
    }

    // No es necesario override de implementedOnlyInA() porque no hay conflicto ni es abstracto

    // Método que tiene implementaciones en ambas interfaces (conflicto)
    // Debemos decidir qué implementación usar o llamar a ambas
    override fun implementedInBoth() {
        super<SecondTrait>.implementedInBoth()  // Llama a implementación de SecondTrait
        super<FirstTrait>.implementedInBoth()   // Llama a implementación de FirstTrait
    }

    // Método abstracto en SecondTrait, lo implementamos aquí
    override fun implementedInOne() {
        // Esta es nuestra implementación propia, que reemplaza la que pudo tener FirstTrait
        print("implementedInOne class implementation\n")
    }

    // Método 'bar' es abstracto en FirstTrait pero tiene implementación en SecondTrait,
    // por lo que debemos sobreescribirlo para resolver ambigüedad
    override fun bar() {
        super<SecondTrait>.bar()  // Elegimos usar la implementación de SecondTrait
    }
}

// Función principal para crear el objeto y llamar a los métodos
fun main() {
    val obj = ClassWithConflict()

    obj.notImplemented()          // Imprime: Normal implementation
    obj.implementedOnlyInA()      // Imprime: only A (implementación por defecto de FirstTrait)
    obj.implementedInBoth()       // Imprime: both, B y luego both, A (llama a ambas implementaciones)
    obj.implementedInOne()        // Imprime: implementedInOne class implementation (nuestra propia)
    obj.bar()                    // Imprime: bar from SecondTrait (implementación elegida)
}
