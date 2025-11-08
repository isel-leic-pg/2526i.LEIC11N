fun main(){
    val v1 = readInt("Valor 1")
    val v2 = readInt("Valor 2")

    val cmp = when {
        v1 < v2 -> "menor que o"
        v1 == v2 -> "igual ao"
        else -> "maior que o"
    }
    println("O valor $v1 é $cmp valor $v2")
}

fun readInt(quest:String):Int {
    print("$quest ? ")
    return readln().toInt()
}