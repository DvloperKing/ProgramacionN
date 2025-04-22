fun main(){
    val alturas=FloatArray(5)
    var suma=0f

    for(i in 0..alturas.size-1){
        print("ingrese la altura ${i+1}: ")
        alturas[i]= readln().toFloat()
        suma+=alturas[i]
    }

    val promedio =suma/alturas.size
    println("altura promedio: $promedio")
    var altos=0; var bajos=0
    
    for(i in 0..alturas.size-1){
        if(alturas[i]>promedio){ altos++ }
        else{ bajos++ }
    }

    println("cantidad de personas mas altas que el promedio: $altos")
    println("cantidad de personas mas bajas que el promedio: $bajos")
}