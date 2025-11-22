fun main() {
 /*   val l1 = "inv2022;Pg;ISEL".split(';')
    println(l1)
    val l2: List<Char> = "ISEL".toList()
    println(l2)
    val l3 = l1.filter{ w -> w.length>=4} // [inv2022, ISEL]
    l3.forEach { println("($it)") }  //(inv2022)
                                     //(ISEL)
    println( l3.map{ it.length } ) // [7, 4]

    println(l3.reversed()) //[ISEL, inv2022]

   // l3.indices.forEach { print("idx: $it ") }
    l3.forEachIndexed { idx, elem -> println("com forEachIndexed= idx: $idx elem: $elem") }

    for (idx in 0..l3.size-1) {
    //for (idx in 0..<l3.size) {
        println("com for= idx: $idx elem: ${l3[idx]}")
    }

    //l3 [inv2022, ISEL]
    println(l3.drop(1)) // [ISEL]
    println(l3.drop(2)) // []
    println(l3.dropLast(1)) // [inv2022]
    println(l3.dropLast(2)) // []

    println(l3 - "ISEL") // [inv2022]
    println(l3 + "ISEL2") // [inv2022, ISEL, ISEL2]
    println(l3 - "6") //[inv2022, ISEL]

    println(l3 - l3.elementAt(0)) //[ISEL]
*/
    //mutableListOf("2","3").remove

    println(digitsOf("ab2 3x=6 "))

}

fun digitsOf(s: String): List<Int>  {
    //s.filter { it.isDigit() } // "236"
    return s.filter { it.isDigit() }
            .map { it.digitToInt() } // [2, 3, 6]
           //.map { it.toString().toInt() } // [2, 3, 6]
}