package colecoes

fun main() {
    val numbers: List<Int> = listOf(1, -2, 3, -4, 5, -6)

    val positives = numbers.filter { x -> x > 0 }

    val negatives = numbers.filter { it < 0 }

    println("Numbers: $numbers")
    println("Positive Numbers: $positives")
    println("Negative Numbers: $negatives")
}