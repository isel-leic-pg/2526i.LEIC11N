fun main(){
    val a = readPositive("Lado A")
    val b = readPositive("Lado B")

    val name = if (a > b) "A" else "B"
    val perimeter = a + a + b + b

    println("Dimensões: $a x $b")
    println("O lado maior é o $name")
    println("Perímetro = $perimeter")
   // println("Perímetro = ${a+a+b+b}")
}

fun readPositive(question: String): Int {
    while(true) {
        print("$question ? ")
        val v = readln().trim().toInt()
        if (v > 0) {
            return v
        }
    }
}
