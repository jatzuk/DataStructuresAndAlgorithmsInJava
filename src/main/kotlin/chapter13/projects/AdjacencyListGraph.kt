package chapter13.projects

import chapter13.AbstractGraph

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

class AdjacencyListGraph(maxVerts: Int) : AbstractGraph<Char>(maxVerts) {
    private val adjacencyList = Array(maxVerts) { ArrayList<Char>() }

    /**
     * [end] means adjusted edge on current [start]
     */
    public override fun addEdge(start: Int, end: Char) {
        adjacencyList[start].add(end)
    }

    override fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        repeat(verts) {
            if (adjacencyList[vertex].contains(it.toChar() + 65) && !vertexes[it]!!.isVisited) return it
        }
        return -1
    }
}
