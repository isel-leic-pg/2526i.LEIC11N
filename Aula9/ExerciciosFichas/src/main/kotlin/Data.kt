data class Date(val day: Int, val  month: Int, val year: Int)

fun Date.toText() = "$day/$month/$year"

fun isLeapYear(y: Int) = y%4 == 0 &&  y%100 != 0 || y%400 == 0

fun Date.maxDayOfMonth(): Int = when(month) {
    1, 3, 5, 7, 8, 10, 12 -> 31
    2 -> if (isLeapYear(year) ) 29 else 28
    else -> 30
}

fun Date.nextDay(): Date = when {
    day + 1 <= maxDayOfMonth() -> Date(day + 1, month, year)
    month < 12 -> Date(1, month + 1, year)
    else -> Date (1, 1, year+1)
}

fun main() {
    val now = Date(28, 2,1900)
    println("Data = ${now.toText()}")
    val after = now.nextDay()
    println("Dia seguinte = ${after.toText()}")
}