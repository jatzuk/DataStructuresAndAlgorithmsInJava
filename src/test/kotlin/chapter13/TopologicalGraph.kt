package chapter13

import org.junit.Before
import org.junit.Test

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

class TopologicalGraphTest {
    private val size = 8
    private val graph = TopologicalGraph(size)

    @Before
    fun setUp() {
        with(graph) {
            repeat(size) { addVertex((65 + it).toChar()) }
            addEdge(0, 3)
            addEdge(0, 4)
            addEdge(1, 4)
            addEdge(2, 5)
            addEdge(3, 6)
            addEdge(4, 6)
            addEdge(5, 7)
            addEdge(6, 7)
        }
    }

    @Test
    fun topologicalGraphTest() {
        graph.topologicalSort()
    }
}
