import pt.isel.canvas.*

const val IMG_SIZE = 64
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

data class Position(val x: Int, val y: Int)

fun Canvas.drawHero(position:Position) {
    drawImage("hero|48,0,48,48", position.x * IMG_SIZE, position.y * IMG_SIZE, IMG_SIZE, IMG_SIZE)
}

fun main() {
    println("start main")
    onStart {
        val canvas = Canvas(IMG_SIZE*GRID_WIDTH, IMG_SIZE*GRID_HEIGHT, BLACK)
        println("start canvas")
        var position = Position(GRID_WIDTH/2, GRID_HEIGHT/2)
        canvas.drawGrid()
        canvas.drawHero(position)

       /* val keyhandler = { k:KeyEvent -> canvas.erase()} //função lambda
        canvas.onKeyPressed(keyhandler)
        canvas.onKeyPressed { //lambda }
*/
        canvas.onKeyPressed { key ->
            /*when {
                key.char == 'a' -> { ....}
            }*/
            /*position = when(key.code) {
                LEFT_CODE -> Position(position.x-1, position.y)
                RIGHT_CODE -> Position(position.x+1, position.y)
                UP_CODE -> Position(position.x, position.y-1)
                DOWN_CODE -> Position(position.x, position.y+1)
                else -> position
            }*/
            position = when {
                key.code == LEFT_CODE && position.x-1 >= 0 -> Position(position.x-1, position.y)
                key.code == RIGHT_CODE && position.x*IMG_SIZE + IMG_SIZE + 1 < GRID_WIDTH*IMG_SIZE -> Position(position.x+1, position.y)
                key.code == UP_CODE -> Position(position.x, position.y-1)
                key.code == DOWN_CODE -> Position(position.x, position.y+1)
                else -> position
            }

            canvas.erase()
            canvas.drawGrid()
            canvas.drawHero(position)
        }
    }
    onFinish {
        println("end canvas")
    }
    println("end main")
}

fun Canvas.drawGrid() {
    (IMG_SIZE..width step IMG_SIZE).forEach {
        drawLine(it, 0, it, height, WHITE, 1)
    }
    (IMG_SIZE..height step IMG_SIZE).forEach {
        drawLine(0, it, width, it, WHITE, 1)
    }
}