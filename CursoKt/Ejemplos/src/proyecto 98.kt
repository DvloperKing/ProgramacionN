fun main(){
    val sueldos:IntArray
    sueldos=IntArray(5)
    for (i in 0..4){
        print("ingrese sueldo ${i+1}:")
        sueldos[i]= readln().toInt()
    }

    for(i in 0..4){ println(sueldos[i]) }
}