package chapter13

import chapter4.Queue
import chapter4.Stack

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

abstract class AbstractGraph<T>(private val maxVerts: Int) {
    protected val vertexes = arrayOfNulls<Vertex>(maxVerts)
    protected var verts = 0

    protected abstract fun addEdge(start: Int, end: T)

    fun addVertex(label: Char) {
        vertexes[verts++] = Vertex(label)
    }

    fun dfs(start: Int = 0) {
        print("Visits: ")
        val stack = Stack(maxVerts)
        vertexes[start]!!.isVisited = true
        displayVertex(start)
        stack.push(start)

        while (!stack.isEmpty()) {
            val vertex = getAdjustedUnvisitedVertex(stack.peek())
            if (vertex == -1) stack.pop()
            else {
                vertexes[vertex]!!.isVisited = true
                displayVertex(vertex)
                stack.push(vertex)
            }
        }
        println()
        resetFlags()
    }

    fun bfs() {
        print("Visits: ")
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
        println()
        resetFlags()
    }

    fun mst() {
        print("Visits: ")
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
        println()
        resetFlags()
    }

    fun mstBfs() {
        print("Visits: ")
        val queue = Queue(maxVerts)
        vertexes[0]!!.isVisited = true
        queue.insert(0)

        while (!queue.isEmpty()) {
            val vertex = queue.remove()
            while (true) {
                val nextVertex = getAdjustedUnvisitedVertex(vertex)
                if (nextVertex == -1) break
                vertexes[nextVertex]!!.isVisited = true
                queue.insert(nextVertex)
                displayVertex(vertex)
                displayVertex(nextVertex)
                queue.insert(nextVertex)
                print(" ")
            }
        }
        println()
        resetFlags()
    }

    protected abstract fun getAdjustedUnvisitedVertex(vertex: Int): Int

    private fun resetFlags() {
        vertexes.forEach { it?.isVisited = false }
    }

    private fun displayVertex(vertex: Int) {
        print(vertexes[vertex]!!.label)
    }

    class Vertex(val label: Char) {
        var isVisited = false
    }
}
