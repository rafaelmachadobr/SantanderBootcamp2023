package controlefluxo.ranges

fun main() {
    for (c in 'a'..'d') {
        print("$c ")
    }
    println("\n-------")

    for (c in 'z' downTo 's' step 2) {
        print("$c ")
    }
    println("\n-------")

    val x = 2
    if (x in 1..5) {
        print("x is in range from 1 to 5")
    }
    println("\n-------")

    if (x !in 6..10) {
        print("x is not in range from 6 to 10")
    }
}