//Se carga una fecha (día, mes y año) por teclado. Mostrar un mensaje si corresponde al
//primer trimestre del año (enero, febrero o marzo)
//Cargar por teclado el valor numérico del día, mes y año. Ejemplo: dia:10 mes:2 año:2017.

fun main(parametro: Array<String>) {
    print("Ingrese día:")
    val dia = readLine()!!.toInt()
    print("Ingrese mes:")
    val mes = readLine()!!.toInt()
    print("Ingrese Año:")
    val año = readLine()!!.toInt()
    if (mes == 1 || mes == 2 || mes == 3)
        print("Corresponde al primer trimestre");
}