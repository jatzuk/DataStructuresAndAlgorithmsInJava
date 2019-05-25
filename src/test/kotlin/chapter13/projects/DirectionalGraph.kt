package chapter13.projects

import org.junit.Before
import org.junit.Test

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
 * ex3 test
 * */
class DirectionalGraphTest {
    private val size = 5
    private val graph = DirectionalGraph(size)

    @Before
    fun setUp() {
        repeat(size) { graph.addVertex((it + 65).toChar()) }
    }

    @Test
    fun directionGraphTest() {
        with(graph) {
            addEdge(0, 2)
            addEdge(1, 0)
            addEdge(1, 4)
            addEdge(4, 2)
            addEdge(3, 4)
            printAdjacencyTable()
        }
    }
}
