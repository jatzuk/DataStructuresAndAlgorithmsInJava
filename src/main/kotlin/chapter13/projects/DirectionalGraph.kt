package chapter13.projects

import chapter13.MatrixGraph

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

/**
 * ex 3
 * */
open class DirectionalGraph(maxVerts: Int) : MatrixGraph(maxVerts) {
    override fun addEdge(start: Int, end: Int) {
        adjustMatrix[start][end] = 1
    }

    fun printAdjacencyTable() {
        println("Adjacency Table:")
        repeat(verts) { dfs(it) }
    }
}
