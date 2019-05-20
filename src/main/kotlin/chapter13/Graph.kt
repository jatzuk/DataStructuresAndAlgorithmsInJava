package chapter13

import chapter4.Queue
import chapter4.Stack

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class Graph(private val maxVerts: Int) {
    protected val vertexes = arrayOfNulls<Vertex>(maxVerts)
    protected val adjustMatrix = Array(maxVerts) { IntArray(maxVerts) }
    protected var verts = 0

    fun addVertex(label: Char) {
        vertexes[verts++] = Vertex(label)
    }

    open fun addEdge(start: Int, end: Int) {
        adjustMatrix[start][end] = 1
        adjustMatrix[end][start] = 1
    }

    fun dfs() {
        val stack = Stack(maxVerts)
        vertexes[0]!!.isVisited = true
        displayVertex(0)
        stack.push(0)

        while (!stack.isEmpty()) {
            val vertex = getAdjustedUnvisitedVertex(stack.peek())
            if (vertex == -1) stack.pop()
            else {
                vertexes[vertex]!!.isVisited = true
                displayVertex(vertex)
                stack.push(vertex)
            }
        }
        resetFlags()
    }

    fun bfs() {
        val queue = Queue(maxVerts)
        vertexes[0]!!.isVisited = true
        displayVertex(0)
        queue.insert(0)

        while (!queue.isEmpty()) {
            val vertex = queue.remove()
            while (true) {
                val nextVertex = getAdjustedUnvisitedVertex(vertex)
                if (nextVertex == -1) break
                vertexes[nextVertex]!!.isVisited = true
                displayVertex(nextVertex)
                queue.insert(nextVertex)
            }
        }
        resetFlags()
    }

    fun mst() {
        val stack = Stack(maxVerts)
        vertexes[0]!!.isVisited = true
        stack.push(0)

        while (!stack.isEmpty()) {
            val vertex = stack.peek()
            val nextVertex = getAdjustedUnvisitedVertex(vertex)
            if (nextVertex == -1) stack.pop()
            else {
                vertexes[nextVertex]!!.isVisited = true
                stack.push(nextVertex)
                displayVertex(vertex)
                displayVertex(nextVertex)
                print(" ")
            }
        }
        resetFlags()
    }

    private fun resetFlags() {
        vertexes.forEach { it?.isVisited = false }
    }

    private fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        repeat(verts) {
            if (adjustMatrix[vertex][it] == 1 && !vertexes[it]!!.isVisited) return it
        }
        return -1
    }

    private fun displayVertex(vertex: Int) {
        print(vertexes[vertex]!!.label)
    }

    class Vertex(val label: Char) {
        var isVisited = false
    }
}
