import pt.isel.canvas.*

const val WIDTH = 800
const val HEIGHT = 500
const val BALL_RADIUS = 50
const val DELTA_RADIUS = 1
val RADIUS_LIMIT = 10..150
val VELOCITY_LIMIT = 10..20

fun Canvas.moveBall(bs: Ball) : Ball {
    // calcula x e y
    // val x = bs.point.x + bs.motion.dx
    // val y = bs.point.y + bs.motion.dy
    val newPosition = bs.point + bs.motion; //está a usar o operador "+" entre Point e Motion

    val dy = if (bs.motion.dy>0 && newPosition.y >= height - bs.radius ||
        bs.motion.dy < 0 && newPosition.y <= bs.radius)
        -bs.motion.dy
    else bs.motion.dy

    val dx = if (bs.motion.dx>0 && newPosition.x >= width - bs.radius ||
        bs.motion.dx < 0 && newPosition.x <= bs.radius)
        -bs.motion.dx
    else bs.motion.dx

    return Ball(newPosition, Motion(dx, dy), bs.radius)
}

fun Canvas.drawBall(ballState: Ball) {
    erase()
    drawCircle(ballState.point.x, ballState.point.y, ballState.radius, RED)
}

fun processKey(bs: Ball, key: Char): Ball {
    return Ball(bs.point,
        //qd carrego no 'm' ou 'M', calcula uma velocidade aleatória
        when {
            key.uppercase() == 'm'.uppercase() -> randomMotion()
            else -> bs.motion
        },
        when {
            key == '-' && /*bs.radius in RADIUS_LIMIT*/
                    bs.radius >= RADIUS_LIMIT.first -> bs.radius - DELTA_RADIUS
            key == '+' && bs.radius <= RADIUS_LIMIT.last -> bs.radius + DELTA_RADIUS
            else -> bs.radius
        }
    )
}

fun start() {
    val arena = Canvas(WIDTH, HEIGHT, BLACK)
    println("Start")
    var ball = Ball(Point(arena.width/2, BALL_RADIUS), randomMotion(), BALL_RADIUS)
    arena.drawBall(ball)

    arena.onTimeProgress(25) { //25 frames per second
        ball = arena.moveBall(ball)
        arena.drawBall(ball)
    }

    arena.onKeyPressed { keyEvent ->
        ball = processKey(ball, keyEvent.char)
        arena.drawBall(ball)
    }
    arena.onMouseDown {
        mouseEvent -> ball = ball.copy(point = Point(mouseEvent.x, mouseEvent.y))
        arena.drawBall(ball)
    }
}

fun finish() {
    println("Bye!")
}

fun main() {
    println("Entry")
    onStart(::start)
    onFinish(::finish)
    println("Exit")
}