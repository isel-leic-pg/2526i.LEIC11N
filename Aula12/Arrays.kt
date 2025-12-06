fun main() {
    val array = arrayOf("1","2","10")
    val array2 = arrayOf(1,2,3,4)
    array.sort()
    array2.sort()
    println("Are equal? ${array.contentEquals(array2)}")
    println("Array: ${array.joinToString(" ", "Prefix: [", "] Postfix", 2, "e mais uns quantos", {elem -> (elem * 10).toString()})}")
}