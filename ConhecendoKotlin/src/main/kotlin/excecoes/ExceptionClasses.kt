package excecoes

fun main() {
    val a = 10
    val b = 0

    try {
        val divisao = a / b
        println("O resultado da divisão é: $divisao")
    } catch (e: ArithmeticException) {
        println("Ocorreu uma exceção aritmética")
    } catch (e: Throwable) {
        println("Erro: ${e.message}")
    } finally {
        println("Fim do programa!")
    }
}