package chapter14

import chapter13.MatrixGraph
import chapter14.MinimumWeightSpanningTree.WeightVertex

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 02.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class DijkstraGraph(maxVerts: Int) : MatrixGraph(maxVerts) {
    private val path = arrayOfNulls<DistPar>(maxVerts)

    init {
        repeat(maxVerts) { row ->
            repeat(maxVerts) { col ->
                adjustMatrix[row][col] = PSEUDO_INFINITY
            }
        }
    }

    override fun addVertex(label: Char) {
        vertexes[verts++] = WeightVertex(label)
    }

    fun addEdge(start: Int, end: Int, weight: Int) {
        adjustMatrix[start][end] = weight
    }

    fun path() {
        (vertexes[0] as WeightVertex).isInTree = true
        var treeSize = 1
        repeat(verts) { path[it] = DistPar(0, adjustMatrix[0][it]) }

        while (treeSize < verts) {
            val index = getMin()
            if (path[index]?.distance == PSEUDO_INFINITY) {
                println("There are unreachable vertices")
                break
            }
            (vertexes[index] as WeightVertex).isInTree = true
            treeSize++
            adjustPath(index, path[index]?.distance!!)
        }
        resetFlags()
        displayPaths()
    }

    private fun adjustPath(currentVertex: Int, startToCurrent: Int) {
        var column = 1
        while (column < verts) {
            if ((vertexes[column] as WeightVertex).isInTree) {
                column++
                continue
            }
            val startToFringe = startToCurrent + adjustMatrix[currentVertex][column]
            if (startToFringe < path[column]!!.distance) {
                path[column]!!.parentVertex = currentVertex
                path[column]!!.distance = startToFringe
            }
            column++
        }
    }

    private fun displayPaths() {
        repeat(verts) {
            print("${vertexes[it]!!.label}=")
            if (path[it]!!.distance == PSEUDO_INFINITY) print("∞")
            else print(path[it]!!.distance)
            print("(${vertexes[path[it]!!.parentVertex]!!.label}) ")
        }
        println()
    }

    private fun getMin(): Int {
        var distance = PSEUDO_INFINITY
        var index = 0
        for (i in 1 until verts) {
            if (!(vertexes[i] as WeightVertex).isInTree && path[i]!!.distance < distance) {
                distance = path[i]!!.distance
                index = i
            }
        }
        return index
    }

    private fun resetFlags() {
        vertexes.forEach { (it as WeightVertex?)?.isInTree = false }
    }

    companion object {
        private const val PSEUDO_INFINITY = Int.MAX_VALUE / 2
    }

    class DistPar(var parentVertex: Int, var distance: Int)
}
