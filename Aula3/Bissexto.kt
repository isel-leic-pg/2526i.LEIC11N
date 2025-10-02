fun main(){
	print("Insira um ano e eu dir-te-ei o número de dias desse ano: ")
	val year = readln().trim().toInt()
	
	//val days = if ((year%4 == 0 && year%100!=0) || year%400==0) 366 else 365
	//println("O ano $year tem $days dias")
	
	println("O ano $year tem ${if ((year%4 == 0 && year%100!=0) || year%400==0) 366 else 365} dias")
	//println(if ((year%4 == 0 && year%100!=0) || year%400==0) 366 else 365)
}