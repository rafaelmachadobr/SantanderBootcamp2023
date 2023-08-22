package introducao

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

fun main() {

    var neverNull: String = "This can't be null"

    var nullable: String? = "You can keep a null here"
    nullable = null

    var inferredNonNull = "The compiler assumes non-null"

    fun strLength(str: String?): Int {
        return str?.length ?: 0
    }

    println(strLength(neverNull))
    println(strLength(nullable))

    println(describeString(null))
    println(describeString(""))
    println(describeString("dio.me"))
}