package Cap3

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyAnnotation

@MyAnnotation
class AnnotatedClass

@MyAnnotation
fun annotatedFunction() {
    println("This is an annotated function")
}

fun main() {
    val clazz: KClass<AnnotatedClass> = AnnotatedClass::class
    val classAnnotations = clazz.annotations
    println("Class annotations: ${classAnnotations.map { it.annotationClass.simpleName }}")

    val function = ::annotatedFunction
    val functionAnnotations = function.annotations
    println("Function annotations: ${functionAnnotations.map { it.annotationClass.simpleName }}")

    annotatedFunction()
}