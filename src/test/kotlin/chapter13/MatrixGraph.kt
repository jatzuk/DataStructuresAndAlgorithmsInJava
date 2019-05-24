package chapter13

import org.junit.Before
import org.junit.Test

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

class MatrixGraphTest {
    private val size = 5
    private val graph = MatrixGraph(size)

    @Before
    fun setUp() {
        repeat(size) { graph.addVertex((65 + it).toChar()) }
        with(graph) {
            addEdge(0, 1)
            addEdge(1, 2)
            addEdge(0, 3)
            addEdge(3, 4)
        }
    }

    @Test
    fun dfsTest() {
        graph.dfs()
    }

    @Test
    fun bfsTest() {
        graph.bfs()
    }

    @Test
    fun mstTest() {
        with(graph) {
            addEdge(0, 2)
            addEdge(0, 4)
            addEdge(1, 3)
            addEdge(1, 4)
            addEdge(2, 3)
            addEdge(2, 4)
            mst()
        }
    }

    @Test
    fun mstBfsTest() {
        with(MatrixGraph(9)) {
            repeat(9) { addVertex((65 + it).toChar()) }
            addEdge(0, 1)
            addEdge(0, 3)
            addEdge(1, 2)
            addEdge(2, 3)
            addEdge(2, 8)
            addEdge(3, 4)
            addEdge(3, 7)
            addEdge(4, 5)
            addEdge(4, 8)
            addEdge(5, 6)
            addEdge(6, 7)
            mstBfs()
        }
    }
}
