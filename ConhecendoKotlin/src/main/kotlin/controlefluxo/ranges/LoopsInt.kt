package controlefluxo.ranges

fun main() {
    println("\n-------")

    for (i in 1..3) {
        print("$i ")
    }
    println("\n-------")

    for (i in 0..<3) {
        print("$i ")
    }
    println("\n-------")

    for (i in 2..8 step 2) {
        print("$i ")
    }
    println("\n-------")

    for (i in 3 downTo 0) {
        print("$i ")
    }
    println("\n-------")
}