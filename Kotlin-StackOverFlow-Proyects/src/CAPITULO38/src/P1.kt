import javax.swing.*

// Función de extensión para JFrame que crea un JMenuBar y lo inicializa con la lambda 'init'
fun JFrame.menuBar(init: JMenuBar.() -> Unit) {
    val menuBar = JMenuBar()  // Paso 1: Crear JMenuBar
    menuBar.init()            // Paso 2: Ejecutar lambda para inicializar JMenuBar
    this.jMenuBar = menuBar   // Paso 3: Asignar JMenuBar al JFrame
}

// Función de extensión para JMenuBar que crea un JMenu con el título 'caption' y lo inicializa
fun JMenuBar.menu(caption: String, init: JMenu.() -> Unit) {
    val menu = JMenu(caption) // Paso 1: Crear JMenu con título
    menu.init()               // Paso 2: Inicializar JMenu con la lambda
    this.add(menu)            // Paso 3: Agregar JMenu al JMenuBar
}

// Función de extensión para JMenu que crea un JMenuItem con el título 'caption' y lo inicializa
fun JMenu.menuItem(caption: String, init: JMenuItem.() -> Unit = {}) {
    val menuItem = JMenuItem(caption) // Paso 1: Crear JMenuItem con título
    menuItem.init()                   // Paso 2: Inicializar JMenuItem con la lambda (vacía por defecto)
    this.add(menuItem)                // Paso 3: Agregar JMenuItem al JMenu
}

// Clase que extiende JFrame y usa las funciones para construir un menú seguro
class MyFrame : JFrame() {
    init {
        // Usamos la función menuBar para construir la barra de menú
        menuBar {
            // Agregamos un menú con título "Menu1"
            menu("Menu1") {
                // Agregamos items al menú "Menu1"
                menuItem("Item1") {
                    // Aquí se puede inicializar el JMenuItem, por ejemplo agregar un ActionListener
                    addActionListener { println("Item1 seleccionado") }
                }
                menuItem("Item2") {
                    addActionListener { println("Item2 seleccionado") }
                }
            }
            // Otro menú llamado "Menu2"
            menu("Menu2") {
                menuItem("Item3") {
                    addActionListener { println("Item3 seleccionado") }
                }
                menuItem("Item4") {
                    addActionListener { println("Item4 seleccionado") }
                }
            }
        }

        // Configuramos otras propiedades del JFrame
        title = "Ejemplo de Constructores Seguros"
        setSize(400, 300)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)  // Centrar la ventana
    }
}

fun main() {
    // Creamos e mostramos la ventana en el hilo de eventos de Swing
    SwingUtilities.invokeLater {
        val frame = MyFrame()
        frame.isVisible = true
    }
}
