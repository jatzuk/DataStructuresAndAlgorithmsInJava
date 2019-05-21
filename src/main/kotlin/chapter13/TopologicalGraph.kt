package chapter13

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 20.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class TopologicalGraph(val size: Int) : Graph(size) {
    override fun addEdge(start: Int, end: Int) {
        adjustMatrix[start][end] = 1
    }

    fun topologicalSort() {
        val array = CharArray(verts)
        val originalVerts = verts
        val originalVertexes = vertexes.copyOf()
        while (verts > 0) {
            val vertex = noSuccessors()
            if (vertex == -1) throw IllegalStateException("Graph has cycles")
            array[verts - 1] = vertexes[vertex]!!.label
            deleteVertex(vertex)
        }
        verts = originalVerts
        originalVertexes.copyInto(vertexes)
        print("Topologically sorted order: ")
        repeat(verts) { print("${array[it]}") }
    }

    private fun deleteVertex(vertex: Int) {
        if (vertex != verts - 1) {
            for (i in vertex until verts - 1) vertexes[i] = vertexes[i + 1]
            for (row in vertex until verts - 1) moveRowUp(row, verts)
            for (col in vertex until verts - 1) moveColLeft(col, verts - 1)
        }
        verts--
    }

    private fun moveRowUp(row: Int, length: Int) {
        repeat(length) { col -> adjustMatrix[row][col] = adjustMatrix[row + 1][col] }
    }

    private fun moveColLeft(col: Int, length: Int) {
        repeat(length) { row -> adjustMatrix[row][col] = adjustMatrix[row][col + 1] }
    }

    private fun noSuccessors(): Int {
        repeat(verts) { row ->
            var isEdge = false
            for (col in 0 until verts) {
                if (adjustMatrix[row][col] > 0) {
                    isEdge = true
                    break
                }
            }
            if (!isEdge) return row
        }
        return -1
    }
}
