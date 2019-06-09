package chapter14.projects

import chapter13.AbstractGraph
import chapter5.Stack

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

class ReferenceGraph(maxVerts: Int) {
    private val vertexes = arrayOfNulls<ReferenceableVertex<Char>>(maxVerts)
    private var verts = 0

    fun addVertex(label: Char) {
        vertexes[verts++] = ReferenceableVertex(label)
    }

    fun addEdge(start: Int, end: Int) {
        vertexes[start]!!.edges.insert(vertexes[end]!!)
    }

    private fun dfs(start: Int) {
        val stack = Stack<ReferenceableVertex<Char>>()
        vertexes[start]!!.isVisited = true
        print(vertexes[start]!!.label)
        stack.push(vertexes[start]!!)

        while (!stack.isEmpty()) {
            val vertex = getAdjustedUnvisitedEdge(stack.peek()!!)
            if (vertex == null) stack.pop()
            else {
                vertex.destination.isVisited = true
                print(vertex.destination.label)
                stack.push(vertex.destination)
            }
        }
        println()
        resetFlags()
    }

    private fun getAdjustedUnvisitedEdge(vertex: ReferenceableVertex<Char>) =
        vertex.edges.getUnvisitedEdge()

    fun displayAdjustMatrix() {
        repeat(verts) { dfs(it) }
    }

    private fun resetFlags() {
        vertexes.forEach { it?.isVisited = false }
    }

    inner class EdgeList {
        private var head: EdgeReference? = null

        fun insert(destination: ReferenceableVertex<Char>) {
            if (head == null) head = EdgeReference(destination)
            else {
                var current = head
                while (current?.next != null) current = current.next
                current!!.next = EdgeReference(destination)
            }
        }

        fun getUnvisitedEdge(): ReferenceableEdge? {
            var current = head
            while (current != null) {
                if (!current.edge.destination.isVisited) return current.edge
                current = current.next
            }
            return null
        }
    }

    inner class EdgeReference(destination: ReferenceableVertex<Char>) {
        var edge: ReferenceableEdge = ReferenceableEdge(destination)
        var next: EdgeReference? = null
    }

    inner class ReferenceableEdge(val destination: ReferenceableVertex<Char>)
    inner class ReferenceableVertex<T>(label: T) : AbstractGraph.BaseVertex<T>(label) {
        val edges = EdgeList()
    }
}
