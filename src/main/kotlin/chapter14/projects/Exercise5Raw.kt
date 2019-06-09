package chapter14.projects

import chapter13.AbstractGraph.BaseVertex
import chapter14.DijkstraGraph.Companion.PSEUDO_INFINITY
import chapter4.Stack

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 09.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Exercise5Raw(maxVerts: Int) {
    private val adjustMatrix = Array(maxVerts) { IntArray(maxVerts) }
    private val vertexes = arrayOfNulls<TSPVertex>(maxVerts)
    private var verts = 0

    init {
        repeat(maxVerts) { row ->
            repeat(maxVerts) { col ->
                adjustMatrix[row][col] = PSEUDO_INFINITY
            }
        }
    }

    fun addEdge(start: Int, end: Int, weight: Int) {
        adjustMatrix[start][end] = weight
        adjustMatrix[end][start] = weight
    }

    fun addVertex(label: Char) {
        vertexes[verts++] = TSPVertex(label)
    }


    fun tsp(start: Int): Int {
        var size = 1
        vertexes[start]!!.isVisited = true
        val stack = Stack(verts)
        stack.push(start)
        val distances = ArrayList<Int>()

        while (!stack.isEmpty()) {
            val vertex = getAdjustedUnvisitedEdge(stack.peek())
            if (vertex == -1) {
                if (adjustMatrix[stack.peek()][start] < PSEUDO_INFINITY && size == verts) {
                    var distance = 0
                    val tmpStack = Stack(verts)
                    while (!stack.isEmpty()) tmpStack.push(stack.pop())
                    while (!tmpStack.isEmpty()) {
                        print(vertexes[tmpStack.peek()]!!.label)
                        val from = tmpStack.peek()
                        stack.push(tmpStack.pop())
                        if (!tmpStack.isEmpty()) distance += adjustMatrix[from][tmpStack.peek()]
                    }
                    distance += adjustMatrix[stack.peek()][start]
                    distances.add(distance)
                    println("${vertexes[start]!!.label}: $distance")
                }
                vertexes[stack.pop()]!!.apply {
                    isVisited = false
                    lastVisited = -1
                }
                size--
            } else {
                vertexes[stack.peek()]!!.lastVisited = vertex
                vertexes[vertex]!!.isVisited = true
                stack.push(vertex)
                size++
            }
        }
        resetFlags()
        return distances.min() ?: -1
    }

    fun findHamiltonianCycle(start: Int) {
        var size = 1
        vertexes[start]!!.isVisited = true
        val stack = Stack(verts)
        stack.push(start)

        while (!stack.isEmpty()) {
            val vertex = getAdjustedUnvisitedEdge(stack.peek())
            if (vertex == -1) {
                if (adjustMatrix[stack.peek()][start] < PSEUDO_INFINITY && size == verts) {
                    val tmpStack = Stack(verts)
                    while (!stack.isEmpty()) tmpStack.push(stack.pop())
                    while (!tmpStack.isEmpty()) {
                        print(vertexes[tmpStack.peek()]!!.label)
                        stack.push(tmpStack.pop())
                    }
                    println(vertexes[start]!!.label)
                }
                vertexes[stack.pop()]!!.apply {
                    isVisited = false
                    lastVisited = -1
                }
                size--
            } else {
                vertexes[stack.peek()]!!.lastVisited = vertex
                vertexes[vertex]!!.isVisited = true
                stack.push(vertex)
                size++
            }
        }
    }

    private fun getAdjustedUnvisitedEdge(vertex: Int): Int {
        for (i in vertexes[vertex]!!.lastVisited + 1 until verts) {
            if (!vertexes[i]!!.isVisited && adjustMatrix[vertex][i] < PSEUDO_INFINITY) return i
        }
        return -1
    }

    private fun resetFlags() {
        vertexes.forEach {
            it?.apply {
                isVisited = false
                lastVisited = -1
            }
        }
    }

    class TSPVertex(label: Char) : BaseVertex<Char>(label) {
        var lastVisited = -1
    }
}
