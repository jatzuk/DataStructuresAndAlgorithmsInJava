package chapter13

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

class Graph(private val maxVerts: Int) {
    private val vertexes = arrayOfNulls<Vertex>(maxVerts)
    private val adjustMatrix = Array(maxVerts) { IntArray(maxVerts) }
    private val stack = Stack(maxVerts)
    var verts = 0

    fun addVertex(label: Char) {
        vertexes[verts++] = Vertex(label)
    }

    fun addEdge(start: Int, end: Int) {
        adjustMatrix[start][end] = 1
        adjustMatrix[end][start] = 1
    }

    fun displayVertex(vertex: Int) {
        print("${vertexes[vertex]!!.label} ")
    }

    fun dfs() {
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
    }

    fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        repeat(verts) {
            if (adjustMatrix[vertex][it] == 1 && !vertexes[it]!!.isVisited) return it
        }
        return -1
    }

    class Vertex(val label: Char) {
        var isVisited = false
    }
}
