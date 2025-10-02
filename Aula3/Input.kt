fun readLine(msg :String) :String {
	print("$msg:")
	return readLine()!! // readln()
}

fun readDouble(msg :String) = readLine(msg).toDouble()
fun readInt(msg :String) = readLine(msg).toInt()

/*
fun readDouble(msg :String) :Double {
	return readLine(msg).toDouble()
}


fun readInt(msg :String) :Int {
	return readLine(msg).toInt()
}
*/