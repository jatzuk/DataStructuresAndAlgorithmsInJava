package chapter13.projects

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

class WarshallAlgorithm(maxVerts: Int) : DirectionalGraph(maxVerts) {
    fun warshallAlgorithm() {
        val transitiveClosure = Array(verts) { IntArray(verts) }
        adjustMatrix.copyInto(transitiveClosure)
        displayMatrix(transitiveClosure)
        println("---------")

        repeat(verts) { row ->
            repeat(verts) { col ->
                if (adjustMatrix[row][col] == 1) {
                    repeat(verts) {
                        if (adjustMatrix[it][row] == 1) transitiveClosure[it][col] = 1
                    }
                }
            }
        }
        displayMatrix(transitiveClosure)
    }

    private fun displayMatrix(matrix: Array<IntArray>) {
        repeat(matrix.size) { row ->
            repeat(matrix.size) { col ->
                print("${matrix[row][col]} ")
            }
            println()
        }
    }
}
