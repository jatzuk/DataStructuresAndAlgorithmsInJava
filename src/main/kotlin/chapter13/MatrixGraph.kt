package chapter13

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

open class MatrixGraph(maxVerts: Int) : AbstractGraph<Int, Char>(maxVerts) {
    val adjustMatrix = Array(maxVerts) { IntArray(maxVerts) }

    public override fun addEdge(start: Int, end: Int) {
        adjustMatrix[start][end] = 1
        adjustMatrix[end][start] = 1
    }

    override fun getAdjustedUnvisitedVertex(vertex: Int): Int {
        repeat(verts) {
            if (adjustMatrix[vertex][it] == 1 && !vertexes[it]!!.isVisited) return it
        }
        return -1
    }
}
