fun main() {
    val a = readInteger("Lado A")
    val b = readInteger("Lado B")
    val c = readInteger("Lado C")

    classificadorDeTriangulos(a, b, c)
}

fun readInteger(question: String): Int {
    print("$question ? ")
    return readln().trim().toInt()
}

fun classificadorDeTriangulos(a: Int, b: Int, c: Int) {
    println("Classificador de triângulos.\nLados A=$a B=$b C=$c")
    /*
    //Solução 1 com if/else
    if (isNegative(a, b, c) || isNotTriangule(a,b,c)) {
        name = "Impossível"
    } else if (a == b && b == c && a == c) {
        name = "Equilátero"
    } else if ( a == b || b == c || a == c)  {
        name = "Isósceles"
    } else {
        name = "Escaleno"
    }*/

    /*
    //Solução 2 com if's encadeados
        if(isNegative(a, b, c) || isNotTriangule(a,b,c)) {
            name = "Impossível"
        } else {
            if (isTrianguleRectangule(a,b,c)) {
                if(a == b || b == c || a == c){
                    name = "Isósceles"
                } else {
                    name = "Escaleno"
                }
            } else {
                name = "Equilátero"
            }
        }*/

    //Solução 3, com when
    val name = when {
        isNegative(a, b, c) || isNotTriangule(a, b, c) -> "Impossível"
        a == b && b == c && a == c -> "Equilátero"
        a == b || b == c || a == c -> "Isósceles"
        else -> "Escaleno"
    }

    println("O triângulo é $name")

    if (isTriangleRectangle(a, b, c))
        println("O triângulo é Rectângulo")

}

fun isTriangleRectangle(a: Int, b: Int, c: Int): Boolean {
    /*
    //Solução 1 para descobrir a hipotenusa e os catetos
    var c1: Int
    var c2: Int

    val h = when {
        a > b && a > c ->  {
            c1 = b
            c2 = c
            a
        }
        b > a && b > c -> {
            c1 = a
            c2 = c
            b
        }
        else -> {
            c1 = a
            c2 = b
            c
        }
    }
    */
    //Solução 2 para descobrir a hipotenusa e os catetos
    var h = Math.max(Math.max(a, b), c)
    var c1 = Math.min(Math.min(a, b), c)
    var c2 = a + b + c - h - c1 // porque a + b + c == h1 + c1 + c2

    //para saber se é rectângulo tem de se verificar o teorema de Pitágoras
    return h * h == c1 * c1 + c2 * c2
}

fun isNegative(a: Int, b: Int, c: Int): Boolean {
    return a <= 0 || b <= 0 || c <= 0
}

fun isNotTriangule(a: Int, b: Int, c: Int): Boolean {
    return a + b <= c || a + c <= b || b + c <= a
}