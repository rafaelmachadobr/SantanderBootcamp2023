package colecoes

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val doubled = numbers.map { x -> x * 2 }

    val tripled = numbers.map { it * 3 }

    println("Numbers: $numbers")
    println("Doubled Numbers: $doubled")
    println("Tripled Numbers: $tripled")

    println("\n-----------------------------------------\n")

    val fruitsBag = listOf("apple", "orange", "banana", "grapes")
    val clothesBag = listOf("shirts", "pants", "jeans")
    val cart = listOf(fruitsBag, clothesBag)
    val mapBag = cart.map { it }
    val flatMapBag = cart.flatMap { it }

    println("Your bags are: $mapBag")
    println("The things you bought are: $flatMapBag")
}