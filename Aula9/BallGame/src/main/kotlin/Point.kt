data class Point(val x: Int = 0, val y: Int = 0)

operator fun Point.plus(motion:Motion) = Point(x + motion.dx, y + motion.dy)
