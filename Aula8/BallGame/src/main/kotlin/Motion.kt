data class Motion(val dx: Int = 0, val dy: Int = 0)

fun randomMotion() = Motion(VELOCITY_LIMIT.random(), VELOCITY_LIMIT.random())
