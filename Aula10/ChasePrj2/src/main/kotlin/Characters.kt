
//val COLS = 3
//val ROWS = 3
//val SQUARE_SIZE = 53
//val GRID_THICKNESS = 10
const val HERO_IMAGE_WIDTH = 288
const val HERO_IMAGE_HEIGHT = 192
const val HERO_IMAGE_SPRITE = 48
const val HERO_IMAGE_HORIZONTAL_SPRITES = 6
const val HERO_IMAGE_VERTICAL_SPRITES = 4

const val ROBOT_IMAGE_SPRITE = 64

const val GARBAGE_IMAGE_WIDTH = 232

const val SPRITE_WIDTH = HERO_IMAGE_WIDTH/HERO_IMAGE_HORIZONTAL_SPRITES
const val SPRITE_HEIGHT = HERO_IMAGE_HEIGHT/HERO_IMAGE_VERTICAL_SPRITES

//val CANVAS_WIDTH = COLS * SQUARE_SIZE + (COLS-1) * GRID_THICKNESS
//val CANVAS_HEIGHT = ROWS * SQUARE_SIZE + (ROWS-1) * GRID_THICKNESS

data class ChaseGame(val player: Hero, val robots: List<Robot> = listOf(), val garbage: List<Garbage> = listOf())
data class Hero(val position: Position, val direction: Direction, val image: Image = Image("hero.png", HERO_IMAGE_SPRITE))
data class Robot(val position: Position, val direction: Direction, val image: Image = Image("robot.png", ROBOT_IMAGE_SPRITE))
data class Garbage(val position: Position, val image: Image = Image("garbage.png", GARBAGE_IMAGE_WIDTH))
data class Position(val x: Int, val y: Int)

data class Image(val name: String, val size:Int)

fun Hero.getSprite(): String {
    return "${image.name}|${ 1 * image.size},${direction.ordinal * image.size},${image.size},${image.size}"
}

enum class Direction() {
    DOWN, LEFT, RIGHT, UP
}