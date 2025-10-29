import pt.isel.canvas.*

fun main() {
    onStart {
        val arena = Canvas(800, 400, CYAN)

        val radius = arena.height/2 - 10
       // arena.drawCircle(arena.width/2, arena.height/2, radius, BLACK)
      //  arena.drawCircle(arena.width/2, arena.height/2, radius, BLACK,3)

      //  arena.onTime(5000) { // apaga a arena ao fim de 5 segundos
       //     arena.erase()
       // }

      //  arena.erase() //apaga a arena
      //  arena.drawLine(10,10, arena.width-10, arena.height-10, 0xEE82EE)
      //  arena.drawRect(10,10, 90, 80, YELLOW)
      // arena.drawRect(10,10, 90, 80, RED, 5)
       // arena.drawArc(50, arena.height/2, 40, 0, 45, GREEN)
      //  arena.drawArc(50, arena.height/2,  40, 90, 270, RED, 8)
      //  arena.drawText(100, 40, "Canvas", GREEN)
      /*  arena.drawImage("lost-valley.jpg", 60, 70, 300, 200) // o ficheiro precisa de estar disponível em resources
        arena.onTime(5000) {
            arena.drawText(10, 50, "tempo")
        }*/
    /*    arena.onTimeProgress(500) { tm:Long ->
           /* val dx = (tm/50).toInt()
            arena.drawCircle(20+dx, 50, 20, RED, 5)
           */
            val m = arena.mouse
            arena.drawCircle(m.x, m.y, 3)


        }
        */
/*
        arena.onMouseDown { me:MouseEvent ->
            arena.drawCircle(me.x, me.y, 20, GREEN)
        }
        */
      /*  arena.onMouseMove { me ->
            val color = if(me.down) RED else GREEN
            arena.drawCircle(me.x, me.y, 2, color)
        }*/
     /*   var x = 10
        arena.onKeyPressed { k ->
            arena.drawText(x, 40, k.char + "") // k.text é a descrição textual da tecla pressionada
            x += 20
        }*/
      //  arena.onMouseDown { arena.close() } // close() fecha a janela

        loadSounds("click", "ping", "pong") // load .wav files, devendo estar presentes na pasta resources
        arena.onMouseDown { playSound("click") } // play click.wav file, devendo estar presente na pasta resources

    }
    onFinish {

    }
}

//fun onTime(delay: Int, handler: () -> Unit)