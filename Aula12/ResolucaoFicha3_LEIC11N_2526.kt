enum class Glass(val message: String) {
    HALF_FULL("More than half"),
    HALF_EMPTY("Less than half")
}

fun f11(number: String, glass: Glass = Glass.HALF_EMPTY): String {
    var res = glass.ordinal
    for (c in number) res += c - '0'
    for (value in Glass.values())
        if (value.ordinal == res % 2) return value.message
    return "not found"
}

fun f11Alternative(number: String, glass: Glass = Glass.HALF_EMPTY): String {
    val res = glass.ordinal + number.map{ it - '0' }.sum() //for (c in number) res += c - '0'
    return Glass.values()[res % 2]?.message ?: "not found"
}

fun f11Alternative2(number: String, glass: Glass = Glass.HALF_EMPTY): String {
    val res = Glass.entries[(glass.ordinal + number.toList().map{ it.digitToInt()}.sum())%2]
    return if (res!= null) res.message else "not found"
}

fun f11Alternative3(number: String, glass: Glass = Glass.HALF_EMPTY): String {
    val res = (glass.ordinal + number.toList().map{ it -> it.digitToInt()}.sum())%2
    return if(res !in 0..Glass.values().lastIndex) "not found"
            else Glass.values()[res].message
}

fun classifier(number:Int):Glass? {
    /* when(number) {
         in 0..49 -> return Glass.HALF_EMPTY
         in 50..100 -> return Glass.HALF_FULL
        else -> return null
    }*/
    return when {
        number in 0..49 -> Glass.HALF_EMPTY
        number in 50..100 -> Glass.HALF_FULL
        else -> null
    }
}

fun mostFrequentOfAllGlasses(values: List<Int>) : Glass? {
    var allGlasses:List<Glass?> = emptyList()
    for (value in values) {
        allGlasses = allGlasses + classifier(value)
    }
    var countHalfFull = allGlasses.filter { glass -> glass == Glass.HALF_FULL }.count()
    var countHalfEmpty = allGlasses.filter { it == Glass.HALF_EMPTY }.count()
    return if(countHalfFull > countHalfEmpty)  Glass.HALF_FULL else if(countHalfFull < countHalfEmpty) Glass.HALF_EMPTY else null
}

fun main() {
    val str = "123"
    //   println("${f1("123", Parity.ODD )}")
      // println("${f2("123", Parity.ODD )}")
    val v1 = f11(str)
    val v1Alternative = f11Alternative(str)
    val v2 = f11(str, Glass.HALF_FULL)
    val v2Alternative = f11Alternative(str, Glass.HALF_FULL)

    println("$v1 = $v1Alternative")
    println("$v2 = $v2Alternative")

 /*   println(
        "The majority of all glasses in this table is: ${
            mostFrequentOfAllGlasses(
                listOf(
                    5,
                    67,
                    5
                )
            )?.message ?: "all at the same level"
        }"
    ); */
}