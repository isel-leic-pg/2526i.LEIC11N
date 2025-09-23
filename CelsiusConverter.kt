fun main() {
val celsius = 37
val fahrenheit = 98.6F

//Conversão de Celcius para Fahrenheit
val resultadoFahrenheit = celsius * 9F/5F + 32
println("${celsius}ºC em Fahrenheit é ${resultadoFahrenheit}ºF")
println("Está certo? ${resultadoFahrenheit == fahrenheit}\n")

//Conversão de Fahrenheit para Celcius
val resultadoCelcius = 5F/9F * (fahrenheit - 32)
println("${fahrenheit}ºF em Fahrenheit é ${resultadoCelcius.toInt()}ºC")
println("Está certo? ${resultadoCelcius.toInt() == celsius}")

}