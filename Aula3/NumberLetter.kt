//val distance = 'a' -'A'

fun main(){
	print("Insira um caracter:")
	val input = readln().first()
	/*	
	if((input >= 'A' && input <='Z') ||
		(input >= 'a' && input <='z'))
		*/
	if(input in 'A'..'Z') {
		println("É letra maiúscula")
		
		//println("Em minúscula é: ${input + ('a'-'A')}")
		val minuscula = input + ('a' -'A') // input + distance
		println("Em minúscula é: $minuscula")
		
	}
	else if (input in 'a'..'z') {
		println("É letra minúscula")
		
		//val maiuscula = input - ('a' -'A')
		val maiuscula = input - ('a' -'A') // input - distance
		println("Em maiúscula é: $maiuscula")
	}
	else if (input in '0'..'9')
		println("É número")
	else 
		println("É outra coisa")
	
	println("Fim")
}