
data class Tempo(val hora: Int = 0, val minutos:Int = 0, val segundos: Int = 0)

//clonar o Tempo, chamando a função copy do data class
fun Tempo.addTime(h:Int, m:Int, s:Int) = copy(hora + h,minutos + m, segundos + s)

//clonar o Tempo, retornando outro objecto Tempo
fun Tempo.addTime2(h:Int, m:Int, s:Int) = Tempo(hora + h,minutos + m, segundos + s)

operator fun Tempo.plus(t: Tempo) = Tempo(hora + t.hora, minutos + t.minutos, segundos + t.segundos)
/*
operator fun Tempo.plus(t: Tempo):Tempo {
    //... validação de segundos > 60 e minutos > 60 ...
    return Tempo(hora + t.hora, minutos + t.minutos, segundos + t.segundos)
}*/

enum class DIAS{ ONE, TWO, THREE }

/*
fun Tempo.formatarTempo(): String{
    return "$hora:$minutos:$segundos" // hh:mm:ss
}*/

//com função extensão
//fun Tempo.formatarTempo() = "$this.hora:$this.minutos:$this.segundos" // hh:mm:ss
fun Tempo.formatarTempo() = "$hora:$minutos:$segundos" // hh:mm:ss

//sem função extensão
fun formatarTempo2(tempo:Tempo) = "${tempo.hora}:${tempo.minutos}:${tempo.segundos}" // hh:mm:ss

fun main() {
    print("Insira o total de segundos: ")
    val totalSegundos = readln().toInt()

    val tempo = Tempo(totalSegundos/3600, totalSegundos % 3600 /60, totalSegundos % 60)

    println("hora = ${tempo.hora}") // mostra o valor de tempo.hora
    //tempo.hora = 7 //o compilador não deixa alterar, porque hora é um val. Para alterar a hora desta forma, a hora teria de ser um var
    println("$totalSegundos s = $tempo") //chama implicitamente o toString() do data class
    println("$totalSegundos s = ${tempo.formatarTempo()}") //com função extensão

    println("$totalSegundos s = ${formatarTempo2(tempo)}") //a chamar função com nome

    //val copia = tempo.copy(hora=8, minutos = tempo.minutos, segundos = tempo.segundos)
    val copia = tempo.copy(hora=8) //no objecto copiado, alterou só a hora, os outros atributos mantêm-se iguais ao original
    println("$totalSegundos s = ${formatarTempo2(copia)} (cópia)") //função "normal"

    println("$totalSegundos s = ${tempo.addTime(1,1,1).formatarTempo()} (cópia - depois de adicionado 1h, 1m, 1s ao tempo original)")
    println("$totalSegundos s = ${tempo.addTime2(1,1,1).formatarTempo()} (cópia - depois de adicionado 1h, 1m, 1s ao tempo original)")

    println("soma de 2 Tempos: ${(tempo + Tempo(2,2,2)).formatarTempo()}")

    //Exemplo com Enums
    println("ordinal DIAS ONE name=${DIAS.ONE.name} value=${DIAS.ONE.ordinal}")
    println("DIR UP name=${Dir.UP.arrow} value=${Dir.UP.delta}")
}

data class Point(val x:Int, val y:Int)

enum class Dir(val arrow: Char, val delta: Point) {
    UP('\u2191', Point(0, +1)),
    RIGHT('\u2192', Point(+1,0)),
    DOWN('\u2193', Point(0,-1)),
    LEFT('\u2190', Point(-1,0))
}
