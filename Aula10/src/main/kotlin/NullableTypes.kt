fun main() {
    var str :String? = "tem valor"
    //println(str.length) //erro em compile time, porque não se pode aceder a uma propriedade de um objecto nullable, se não for validado primeiro que não é null

    if(str != null) {
        println(str.length) //já não dá erro em compile time, por validámos em 1º lugar que o objecto não é null
    }
    println(str?.length) // safe call. Se str for null, str.length não é avaliada, e devolve logo null

    println(str!!.length) //ignora o compile time error de chamar uma propriedade sobre um valor nullable

    println(str?.length ?: "não vai mostrar o default") // Elvis operator. str?.length não é null e por isso não vai mostrar o valor por omissão

    str = null
    //println(str.length) //erro em compile time, porque não se pode aceder a uma propriedade de um objecto nullable, se não for validado primeiro que não é null

    println(str?.length) // safe call. Sabemos que aqui str é null, assim str.length não é avaliada, e devolve logo null

    println(str?.length ?: "Rock&Roll!!!") // Elvis operator. Se str?.length devolver null, então vou devolver um valor por omissão "Rock&Roll!!!"
    println(null ?: "Rock&Roll2!!!") // Elvis operator. como o valor é null, então vou devolver um valor por omissão "Rock&Roll2!!!"

    //println(str!!.length) //isto dá NPE (NullPointerException)
}