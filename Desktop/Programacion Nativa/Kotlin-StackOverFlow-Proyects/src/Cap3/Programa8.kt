package Cap3

annotation class SimpleAnnotation

annotation class AnnotationWithConstructor(val number: Int)

@SimpleAnnotation
@AnnotationWithConstructor(42)
class AnnotatedClass

fun main() {
    val clazz = AnnotatedClass::class
    val annotations = clazz.annotations

    annotations.forEach { annotation ->
        when (annotation) {
            is SimpleAnnotation -> println("Found SimpleAnnotation")
            is AnnotationWithConstructor -> println("Found AnnotationWithConstructor with number: ${annotation.number}")
        }
    }
}