fun main(){
   println("Caracter lido: ${readChar()}")
}

fun readChar(): Char {
    print("Insira uma letra: ")
    return readln()[0]
}
