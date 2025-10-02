val PI = 3.14159 

fun circleArea(raio :Double) :Double {
	return PI * raio * raio
}

fun main(){
	val raio = readDouble("Insira o raio")
	val area = circleArea(raio.toDouble())
	println("Area do círculo com raio $raio é $area")
	println("A fórmula é $PI * $raio * $raio")
}