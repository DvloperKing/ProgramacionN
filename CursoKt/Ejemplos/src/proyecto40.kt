fun largo(nombre: String): Int {
    return nombre.length
}

fun main(parametro: Array<String>) {
    print("Ingrese un nombre:")
    val nombre1 = readLine()!!
    print("Ingrese otro nombre:")
    val nombre2 = readLine()!!
    if (largo(nombre1) == largo(nombre2))
        print("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    else
        if (largo(nombre1) > largo(nombre2))
            print("$nombre1 es mas largo")
        else
            print("$nombre2 es mas largo")
}