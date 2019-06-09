package chapter14.projects

import chapter14.DijkstraGraph

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

class FloydAlgorithm(maxVerts: Int) : DijkstraGraph(maxVerts) {
    fun floydAlgorithm(): Array<IntArray> {
        val matrix = adjustMatrix.copyOf()
        repeat(verts) { row ->
            repeat(verts) { col ->
                if (matrix[row][col] < PSEUDO_INFINITY) {
                    repeat(verts) { z ->
                        if (matrix[z][col] < PSEUDO_INFINITY) {
                            val value = matrix[row][col] + matrix[z][row]
                            val oldValue = matrix[z][col]
                            if (value < oldValue) matrix[z][col] = value
                        }
                    }
                }
            }
        }
        return matrix
    }

    fun displayMatrix(matrix: Array<IntArray>) {
        repeat(verts) { row ->
            repeat(verts) { col ->
                if (matrix[row][col] == PSEUDO_INFINITY) print(" - ")
                else print("${matrix[row][col]} ")
            }
            println()
        }
    }
}
