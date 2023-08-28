package funcoesescopo

fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {
            println("\tis empty? " + isEmpty())
            println("\tlength = $length")
            length
        } ?: println("\tis null")
    }

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")
}
