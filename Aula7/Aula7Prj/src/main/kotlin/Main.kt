fun main() {
    println("Hello".contarVogais())
}

fun String.contarVogais() = this.count { it.lowercaseChar() in "aeiou" }

