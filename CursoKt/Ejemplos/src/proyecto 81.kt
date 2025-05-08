fun main(){
    print("ingrese un nombre: ")
    val nombre1 = readln()
    print("ingrese otro nombre: ")
    val nombre2 = readln()
    if(largo(nombre1)==largo(nombre2)){ print("los nombres: $nombre1 y $nombre2 tienen la misma longitud") }
    else if(largo(nombre1)>largo(nombre2)){ print("$nombre1 es mas largo") }
    else{ print("$nombre1 es mas largo") }
}

fun largo(nombre:String):Int = nombre.length