import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UtilTest {

    @Test
    fun testIncrement(){
        val result = incremento(2)
        assertTrue( result == 3)
        assertEquals(3, result)
    }

    @Test
    fun testGenerateRandomCenas(){
        val generated = generateRandom("")
        assertEquals(6, generated.length)
        assertLettersDuplicated(generated)
    }
}

fun assertLettersDuplicated(generated: String) {

    //solução recorrendo a uma mutableList, só com letras de A até Z, para contar o número de vezes que cada letra aparece
    var alphabet = 'a'..'z'
    var letterCounter = MutableList(alphabet.count()) {0} // inicializa todos os elementos da lista a 0

    generated.lowercase().forEach {
        var letterIndex = alphabet.indexOf(it)
        letterCounter[letterIndex]++
    }
    letterCounter.forEach {
        assertTrue( it == 0 || it == 2) //o teste passa se, para cada letra, é encontrada 0 vezes ou então é achada duplicada 1x
    }

/*
   //solução sem listas, com o "complicómetro" ligado, para saber se para cada letra, esta tem mais ocorrências na String
    var foundMoreDuplicates = 0
    var processedLetters = ""

    //vai iterar cada letra uma a uma
    for (letterIndex in 0..<generated.length) {
        val letter = generated[letterIndex] // vai obter a letra posicionada no index letterIndex
        if (!processedLetters.contains(letter)) { // se a String de letras já processadas não tem a letra a ser processada no momento
            println("Letras processadas: $processedLetters")
            processedLetters += letter // adiciona a letra à String de letras já processadas
            if (letterIndex + 1 < generated.length) { // se o index da letra seguinte, ainda está dentro da dimensão da String
              //  for (innerIndex in letterIndex + 1..<generated.length) { // loop interno, para ver se encontra mais vezes aquela letra no resto da String
                    if (generated.indexOf(letter, letterIndex + 1) != -1) { // indexOf retorna -1 quando não encontra a letra mais vezes no resto da string
                        foundMoreDuplicates++ //counter = counter +1  // se encontrou a letra pelo menos mais 1 vez, incrementa o contador
               //         break //sai do loop interno, não precisa de procurar mais vezes a mesma letra
                    }
               // }
            }
            println("Encontrei a letra $letter pelo menos mais $foundMoreDuplicates vezes")
            foundMoreDuplicates = 0
        }
    } */
}