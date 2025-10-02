fun main(){
	print("Insira um número:")
	val num = readln().trim().toInt()
	if(num > 0) {
		println("Positivo")
		println("ok?")
	} else if(num == 0)
		println("Zero")
	else
		println("Negativo")
}