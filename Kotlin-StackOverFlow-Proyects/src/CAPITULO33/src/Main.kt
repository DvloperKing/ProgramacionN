// Simulación sencilla de RecyclerView en consola

// Clase que representa un "ViewHolder" simple que "muestra" un item
class ViewHolder {
    fun bind(item: String) {
        println("Mostrando item: $item")
    }
}

// Adaptador simulado que contiene los datos y "crea" y "actualiza" ViewHolders
class Adapter(private val items: List<String>) {

    // Simula crear un ViewHolder
    fun createViewHolder(): ViewHolder {
        println("Creando ViewHolder")
        return ViewHolder()
    }

    // Simula "vincular" un ViewHolder con un dato específico
    fun bindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        println("Vinculando ViewHolder con posición $position")
        holder.bind(item)
    }

    fun getItemCount() = items.size

    // Simula el proceso completo de mostrar todos los items
    fun showAllItems() {
        for (pos in 0 until getItemCount()) {
            val vh = createViewHolder()
            bindViewHolder(vh, pos)
        }
    }
}

fun main() {
    val datos = listOf("Manzana", "Banana", "Cereza", "Durazno", "Elote")

    val adaptador = Adapter(datos)

    println("Simulación de RecyclerView\n")

    adaptador.showAllItems()
}
