import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import java.lang.ref.WeakReference

// 1. Inicialización perezosa (lazy)
// La propiedad 'fooLazy' se inicializa sólo cuando se accede por primera vez
val fooLazy: Int by lazy {
    println("Inicializando fooLazy")  // Se imprime solo la primera vez
    1 + 1  // El valor que se guarda en fooLazy
}

// 2. Propiedad observable
// 'fooObservable' notifica cada vez que cambia su valor, con los valores anterior y nuevo
var fooObservable: Int by Delegates.observable(1) { property, oldValue, newValue ->
    println("${property.name} cambió de $oldValue a $newValue")  // Se imprime el cambio
}

// 3. Propiedad delegada a un mapa
// Propiedades que obtienen su valor directamente de un mapa de claves y valores
val map = mapOf("fooMap" to 1)  // Mapa con clave "fooMap" y valor 1
val fooMap: Int by map  // La propiedad fooMap obtiene el valor asociado a "fooMap"

// 4. Delegación personalizada: clase que define cómo se obtiene el valor de la propiedad
class MyDelegate {
    // Operador getValue devuelve el valor cuando se accede a la propiedad delegada
    operator fun getValue(owner: Any?, property: KProperty<*>): String {
        return "Valor delegado personalizado"  // Valor fijo devuelto
    }
}

// Uso de la delegación personalizada para la propiedad fooCustom
val fooCustom: String by MyDelegate()

// 5. Delegado personalizado para WeakReference
// Clase que permite mantener una referencia débil a un objeto, para evitar fugas de memoria
class WeakReferenceDelegate<T>(initialValue: T? = null) : ReadWriteProperty<Any, T?> {
    // Internamente mantiene una WeakReference al valor
    private var reference = WeakReference(initialValue)

    // Devuelve el valor referenciado si no ha sido recolectado
    override fun getValue(thisRef: Any, property: KProperty<*>): T? = reference.get()

    // Actualiza la referencia débil con el nuevo valor asignado
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        reference = WeakReference(value)
    }
}

// Clase que usa la referencia débil con delegado personalizado
class MyMemoryExpensiveClass {
    companion object {
        // Propiedad delegada que mantiene referencia débil a una instancia de esta clase
        var reference: MyMemoryExpensiveClass? by WeakReferenceDelegate()

        // Método para ejecutar un bloque sólo si la referencia sigue vigente
        fun doWithReference(block: (MyMemoryExpensiveClass) -> Unit) {
            reference?.let(block)  // Ejecuta el bloque sólo si reference no es null
        }
    }

    init {
        // Al crear la instancia, se guarda en la referencia débil
        reference = this
    }
}
fun main() {
    // Prueba lazy: se inicializa sólo la primera vez que se accede
    println("Antes de acceder a fooLazy")
    println("fooLazy = $fooLazy")  // Aquí se imprime "Inicializando fooLazy" y el valor 2
    println("Accediendo de nuevo a fooLazy")
    println("fooLazy = $fooLazy")  // Ya no se inicializa de nuevo, sólo imprime el valor

    // Prueba observable: se imprime mensaje cuando cambia el valor
    fooObservable = 2  // Imprime: fooObservable cambió de 1 a 2

    // Prueba delegación a mapa: obtiene el valor del mapa
    println("fooMap = $fooMap")  // Imprime 1

    // Prueba delegación personalizada: obtiene valor fijo definido en MyDelegate
    println("fooCustom = $fooCustom")  // Imprime "Valor delegado personalizado"

    // Prueba WeakReference con delegado personalizado
    val instance = MyMemoryExpensiveClass()  // Se crea instancia y se guarda en referencia débil
    MyMemoryExpensiveClass.doWithReference {
        println("Ejecutando con referencia a MyMemoryExpensiveClass: $it")
    }

    // En un entorno real, 'instance' puede ser recolectada por el GC si no hay referencias fuertes
}
