import pt.isel.canvas.*

const val IMG_SIZE = 64
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

fun main() {
    println("start main")
    onStart {
        val canvas = Canvas(IMG_SIZE*GRID_WIDTH, IMG_SIZE*GRID_HEIGHT, BLACK)
        println("start canvas")
        var hero = Hero(Position(GRID_WIDTH/2, GRID_HEIGHT/2), Direction.DOWN)

        drawHero(canvas, hero)

        canvas.onKeyPressed { key ->
            val cell = when {
                //Pair(Cell(max(p.position.row - 1, 0), p.position.col), Directions.UP)
                key.code == LEFT_CODE && hero.position.x-1 >= 0 -> Pair(Position(hero.position.x-1, hero.position.y), Direction.LEFT)
                key.code == RIGHT_CODE && hero.position.x*IMG_SIZE + IMG_SIZE + 1 < GRID_WIDTH*IMG_SIZE -> Pair(Position(hero.position.x+1, hero.position.y), Direction.RIGHT)
                key.code == UP_CODE && hero.position.y-1 >= 0 -> Pair(Position(hero.position.x, hero.position.y-1), Direction.UP)
                key.code == DOWN_CODE && hero.position.y * IMG_SIZE + IMG_SIZE + 1 < GRID_HEIGHT*IMG_SIZE -> Pair(Position(hero.position.x, hero.position.y+1), Direction.DOWN)
                else -> Pair(hero.position, hero.direction)
            }
            hero = Hero(cell.first, cell.second)
            drawHero(canvas, hero)
        }
    }
    onFinish {
        println("end canvas")
    }
    println("end main")
}

fun drawHero(canvas: Canvas, hero: Hero) {
    canvas.erase()
    canvas.drawGrid()
    canvas.drawHeroSprite(hero)
}

fun Canvas.drawGrid() {
    (IMG_SIZE..width step IMG_SIZE).forEach {
        drawLine(it, 0, it, height, WHITE, 1)
    }
    (IMG_SIZE..height step IMG_SIZE).forEach {
        drawLine(0, it, width, it, WHITE, 1)
    }
}

/*
fun Canvas.drawHero(position:Position) {
    drawImage("hero|48,0,48,48", position.x * IMG_SIZE, position.y * IMG_SIZE, IMG_SIZE, IMG_SIZE)
}*/

fun Canvas.drawHeroSprite(hero:Hero) {
    //48,0,48,48 ----> x,y,w,h
    drawImage(hero.getSprite(), hero.position.x * IMG_SIZE, hero.position.y * IMG_SIZE, IMG_SIZE, IMG_SIZE)
}