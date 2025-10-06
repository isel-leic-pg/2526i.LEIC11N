//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val input = "Contar vogais até achar o ponto."
    val resultado = contadorDeVogais(input)
    println("A frase \'$input\' tem $resultado vogais.")

}

fun contadorDeVogais(frase: String):Int {
    var contador = 0
    frase.forEach {
        when(it.lowercase()) {
            "a", "e", "i", "o", "u" -> contador++ // ++contador //contador = contador + 1 // contador +=1
            "." -> return contador
        }
    }
    /*for (letra in frase) {
        when(letra.lowercase()) {
            "a", "e", "i", "o", "u" -> contador++ // ++contador //contador = contador + 1 // contador +=1
            "." -> return contador
        }
    }*/
    return contador
}
