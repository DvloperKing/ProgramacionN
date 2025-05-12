fun main() {
    val temperatura = 30

    if (temperatura < 10) {
        println("Hace frío")
    } else if (temperatura in 10..25) {
        println("Clima agradable")
    } else {
        println("Hace calor")
    }
}