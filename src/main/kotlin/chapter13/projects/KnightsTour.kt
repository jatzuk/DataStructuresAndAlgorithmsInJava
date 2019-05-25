package chapter13.projects

import chapter4.Stack
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 25.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class KnightsTour {
    class Canvas : JPanel(), ActionListener {
        private val board = Array(N) { BooleanArray(N) }
        private val bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        private val knight = Knight
        private var prevX = -SQUARE_SIZE
        private var prevY = -SQUARE_SIZE
        private val timer = Timer(300, this)

        init {
            isFocusable = true
            preferredSize = Dimension(WIDTH, HEIGHT)
            drawBoard()
            addKeyListener(object : KeyAdapter() {
                override fun keyPressed(e: KeyEvent) {
                    if (e.keyCode == KeyEvent.VK_SPACE) solve()
                }
            })
//            timer.start()
        }

        override fun actionPerformed(e: ActionEvent?) {
            solve()
        }

        override fun paint(g: Graphics) {
            super.paint(g)
            g.drawImage(bufferedImage, 0, 0, this)
        }

        @Suppress("NAME_SHADOWING")
        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            val g = bufferedImage.graphics as Graphics2D
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            val x = knight.x * 50
            val y = knight.y * 50
            g.drawImage(knight.image, x, y, this)
            g.color = Color.GREEN
            g.fillOval(x, y + SQUARE_SIZE - 20, 20, 20)
            g.color = Color.BLACK
            g.drawString(knight.moves.toString(), x + 5, y + SQUARE_SIZE - 5)
        }

        private fun solve() {
            val stack = Stack(N * N)
            board[knight.x][knight.y] = true
            stack.push(0)

            while (!stack.isEmpty()) {
                val m = stack.peek()
                if (stack.isFull()) timer.stop()


            }

            prevX = knight.x
            prevY = knight.y
            knight.x++
            knight.moves++
            repaint()
        }

        private fun drawBoard() {
            repeat(N) { y ->
                repeat(N) { x ->
                    with(bufferedImage.graphics as Graphics2D) {
                        color = if ((x + y) and 1 == 0) Color.WHITE else BROWN
                        fillRect(x * 50, y * 50, SQUARE_SIZE, SQUARE_SIZE)
                    }
                }
            }
        }

        companion object {
            private const val WIDTH = 400
            private const val HEIGHT = 400
            private const val SQUARE_SIZE = 49
            private const val N = 8
            private val BROWN = Color(205, 133, 63)
        }
    }

    object Frame : JFrame("Knight's Tour") {
        init {
            contentPane = Canvas()
            pack()
            setLocationRelativeTo(null)
            defaultCloseOperation = EXIT_ON_CLOSE
        }
    }

    object Knight {
        var x = 0
        var y = 0
        val image = loadImage()
        var moves = 0

        private fun loadImage(): BufferedImage {
            val image =
                ImageIO.read(File("src\\main\\resources\\chapter13\\chess-knight.png")) as BufferedImage
            val type = BufferedImage.TYPE_INT_ARGB
            val scaledImage = BufferedImage(45, 45, type)
            with(scaledImage.createGraphics()) {
                composite = AlphaComposite.Src
                drawImage(image, 0, 0, 45, 45, null)
                dispose()
            }
            return scaledImage
        }
    }
}
