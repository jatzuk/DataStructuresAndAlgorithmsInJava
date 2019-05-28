package chapter13.projects

import chapter13.AbstractGraph.Vertex
import chapter5.Stack
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

object KnightsTour : JFrame("Knight's Tour") {
    private const val N = 8
    private val knight = Knight
    private val board = Array(N) { IntArray(N) }
    private val BROWN = Color(205, 133, 63)
    private val vertexes = arrayOfNulls<KnightVertex<Int>>(N * N)
    private var verts = 0

    init {
        contentPane = Canvas
        pack()
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        repeat(vertexes.size) { addVertex(it) }
        repeat(N) { y ->
            repeat(N) { x ->
                repeat(knight.moves.size) {
                    val dx = knight.moves[it][0]
                    val dy = knight.moves[it][1]
                    try {
                        if (isValidMove(x + y, dx + dy)) addEdge(x + y, dx + dy)
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        println("dx: $dx; dy: $dy")
                    }
                }
            }
        }

//        board[0][0] = 0
//        knight.y = 0
//        knight.x = 0
//        knight.movesCounter = 1
        solve()
    }

    private fun solve() {
        val stack = Stack<Int>()
        vertexes[0]!!.label = 0
        vertexes[0]!!.isVisited = true
        stack.push(0)

        while (!stack.isEmpty()) {
            val m = stack.peek()!!

            if (stack.isFull()) {
                println("WON")
                break
            }

            val vertex = getAdjustedUnvisitedVertex(m)
            if (vertex == -1) {
                with(vertexes[stack.pop()!!]!!) {
                    label = -1
                    isVisited = false
                    lastVisited = -1
                }
            } else {
                vertexes[vertex]!!.isVisited = true
                vertexes[m]!!.label = 1
                vertexes[m]!!.lastVisited = vertex
                stack.push(vertex)
            }
        }
    }

    private fun knightMove(x: Int = knight.x, y: Int = knight.y): Boolean {
        println("move: ${knight.movesCounter}")
        if (knight.movesCounter == N * N) return true
        repeat(knight.moves.size) {
            val dx = knight.moves[it][0] + x
            val dy = knight.moves[it][1] + y
            if (isValidMove(dx, dy)) {
                board[dy][dx] = knight.movesCounter++
                knight.x = dx
                knight.y = dy
                return true
            }
            return@repeat
        }

        return false
    }

    private fun isValidMove(x: Int, y: Int) = x in 0 until N && y in 0 until N && board[y][x] == 0

    private fun addVertex(label: Int) {
        vertexes[verts++] = KnightVertex(label)
    }

    private fun addEdge(start: Int, end: Int) {
        board[start][end] = 1
        board[end][start] = 1
    }

    private fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        for (i in vertexes[vertex]!!.lastVisited + 1 until verts) {
            if (board[vertex][i] == 1 && !vertexes[i]!!.isVisited) return i
        }
        return -1
    }

    object Canvas : JPanel(), ActionListener {
        private const val SQUARE_SIZE = 49
        private const val WIDTH = N * 50
        private const val HEIGHT = N * 50
        private val bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        private const val DELAY = 300
        private val timer = Timer(DELAY, this)
        private var isRunning = false

        init {
            isFocusable = true
            isResizable = false
            preferredSize = Dimension(WIDTH, HEIGHT)
            drawBoard()
            addKeyListener(object : KeyAdapter() {
                override fun keyPressed(e: KeyEvent) {
                    if (e.keyCode == KeyEvent.VK_SPACE) {
                        isRunning = if (!isRunning) {
                            timer.start()
//                            solve()
                            true
                        } else {
                            timer.stop()
                            false
                        }
                    }
                }
            })
        }

        override fun actionPerformed(e: ActionEvent?) {
//            knightMove()
            repaint()
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
//            repeat(N) { row ->
//                repeat(N) { col ->
//                    if (board[row][col] > 0) {
//                        val x = col * 50
//                        val y = row * 50
////                        g.drawImage(knight.image, x, y, this)
////                        g.color = Color.GREEN
////                        g.fillOval(x, y + SQUARE_SIZE - 20, 20, 20)
//                        g.color = Color.BLACK
//                        g.drawString(knight.movesCounter.toString(), x + 5, y + SQUARE_SIZE - 5)
//                    }
//                }
//            }
            val x = knight.x * 50
            val y = knight.y * 50
            g.drawImage(knight.image, x, y, this)
            g.color = Color.GREEN
            g.fillOval(x, y + SQUARE_SIZE - 20, 20, 20)
            g.color = Color.BLACK
            g.drawString(knight.movesCounter.toString(), x + 5, y + SQUARE_SIZE - 5)
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
    }

    object Knight {
        var x = 0
        var y = 0
        val image = loadImage()
        var movesCounter = 0
        var moves = arrayOf(
            intArrayOf(1, -2),
            intArrayOf(2, -1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(-1, 2),
            intArrayOf(-2, 1),
            intArrayOf(-2, -1),
            intArrayOf(-1, -2)
        )

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

    class KnightVertex<T>(override var label: T) : Vertex<T>(label) {
        val visitsStack = Stack<Int>()
        var lastVisited = -1
    }

    private fun Stack<Int>.isFull() = cyclicalList.size == N
}
