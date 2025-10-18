fun main(){
    println(p2("Carla", "Clara"))
    println(p2( a="Pg"))
    println(p2( "Pedro"))
    println(p2( "Isel", "ipl"))

    println(f(1, "EDCBA12345"))
    println(f(10, "ISEL2024"))
    println(f(3, "12AB"))
    println(f(a=2))
}

fun p2(a:String, b:String="Pg"): Char {
    val n = when {
        a.length == b.length -> 1
        a == b -> 2
        a[0] == b[0] -> 3
        else -> 0
    }
    /*
    //Equivalente a:
    val result:Int
    if(a.length == b.length)
        result = 1
    else if (a == b)
        result = 2
    else if (a[0] == b[0])
        result = 3
    else
        result = 0
    */
    return "?C=1"[n]
}

fun f(a:Int, b:String = "ABC321"): Int {
    val max = b.length - 1
    return if (a in 0 ..  max)
        (b[a] - 'A') + (b[max-a] - '0')
    // se for invocado com:
    // f(1, "EDCBA12345") // ('D' - 'A') + ('4' - '0') // 3 + 4 // 7
    // f(3, "12AB") //('B' - 'A') + ('1' - '0') // 1 + 1 // 2
    // f(a=2) // ('C' - 'A') + ('3' -'0') // 2 + 3 // 5
    else a
}
