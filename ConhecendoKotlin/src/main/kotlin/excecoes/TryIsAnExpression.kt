package excecoes

fun main() {
    val a = 10
    val b = 2

    val divisao : Int? = try { a / b } catch (e: ArithmeticException) { null }
    println("O resultado da divisão é: $divisao")
}