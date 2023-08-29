package excecoes

data class Person(val name: String?)

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val person = Person("Rafael")
    val name = person.name ?: fail("Name required")
    println(name)
}