package chapter13.projects

import chapter13.AbstractGraph.Vertex
import chapter13.projects.KnightsTour.Canvas.switchState
import chapter5.Stack
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
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
    private const val N = 5
    private const val SIZE = N * N
    private val vertexes = Array(SIZE) { BoardSquare(-1) }
    private val matrix = Array(SIZE) { IntArray(SIZE) }
    private val stack = Stack<Int>()
    private val BROWN = Color(205, 133, 63)
    private val knight = Knight
    private var backtrackFlag = false

    init {
        contentPane = Canvas
        pack()
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        repeat(N) { y ->
            repeat(N) { x ->
                repeat(knight.moves.size) { move ->
                    val dx = knight.moves[move][0]
                    val dy = knight.moves[move][1]
                    if (isValidMove(x + dx, y + dy)) {
                        addEdge(y * N + x, (y + dy) * N + (x + dx))
                    }
                }
            }
        }

        vertexes[0].label = 0
        vertexes[0].isVisited = true
        stack.push(0)
    }

    private fun knightMove() {
        if (stack.isFull()) {
            switchState()
            return
        }

        if (!stack.isEmpty()) {
            val top = stack.peek()!!
            val vertex = getAdjustedUnvisitedVertex(top)
            if (vertex == -1) {
                with(vertexes[stack.pop()!!]) {
                    isVisited = false
                    lastVisited = -1
                    backtrackFlag = true
                    knight.update(top % N, top / N, knight.movesCounter - 1)
                }
            } else {
                vertexes[top].apply {
                    isVisited = true
                    lastVisited = vertex
                }
                stack.push(vertex)
                knight.update(vertex % N, vertex / N, knight.movesCounter + 1)
            }
        }
    }

    private fun isValidMove(x: Int, y: Int) = x in 0 until N && y in 0 until N

    private fun addEdge(start: Int, end: Int) {
        matrix[start][end] = 1
    }

    private fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        for (i in vertexes[vertex].lastVisited + 1 until SIZE) {
            if (matrix[vertex][i] == 1 && !vertexes[i].isVisited) return i
        }
        return -1
    }

    object Canvas : JPanel(), ActionListener {
        private const val SQUARE_SIZE = 49
        private const val WIDTH = N * 50
        private const val HEIGHT = N * 50
        private val bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        private var isRunning = false
        private const val DELAY = 300
        private val timer = Timer(DELAY, this)

        init {
            isFocusable = true
            isResizable = false
            preferredSize = Dimension(WIDTH, HEIGHT)
            drawBoard()
            addKeyListener(object : KeyAdapter() {
                override fun keyPressed(e: KeyEvent) {
                    if (e.keyCode == KeyEvent.VK_SPACE) switchState()
                }
            })
        }

        override fun actionPerformed(e: ActionEvent?) {
            knightMove()
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
            val x = knight.x * 50
            val y = knight.y * 50

            if (backtrackFlag) {
                g.color = if ((knight.x + knight.y) and 1 == 0) Color.WHITE else BROWN
                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE)
                backtrackFlag = false
            } else {
                g.color = Color.GREEN
                g.fillOval(x + SQUARE_SIZE / 4, y + SQUARE_SIZE / 4, 25, 25)
                g.color = Color.BLACK
                g.drawString(knight.movesCounter.toString(), x + 20, y + SQUARE_SIZE - 20)
            }
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

        fun switchState() {
            isRunning = if (!isRunning) {
                timer.start()
                true
            } else {
                timer.stop()
                false
            }
        }
    }

    object Knight {
        var x = 0
        var y = 0
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

        fun update(x: Int, y: Int, moves: Int) {
            with(knight) {
                this.x = x
                this.y = y
                movesCounter = moves
            }
        }
    }

    class BoardSquare<T>(override var label: T) : Vertex<T>(label) {
        var lastVisited = -1
    }

    private fun Stack<Int>.isFull() = cyclicalList.size == SIZE
}
