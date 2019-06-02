package chapter14

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

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

class MinimumWeightSpanningTreeTest {
    private val graph = MinimumWeightSpanningTree(20)

    @Before
    fun setUp() {
        repeat(6) { graph.addVertex((it + 65).toChar()) }
        with(graph) {
            addEdge(0, 1, 6)
            addEdge(0, 3, 4)
            addEdge(1, 2, 10)
            addEdge(1, 3, 7)
            addEdge(1, 4, 7)
            addEdge(2, 3, 8)
            addEdge(2, 4, 5)
            addEdge(2, 5, 6)
            addEdge(3, 4, 12)
            addEdge(4, 5, 7)
        }
    }

    @Test
    fun minimumWeightSpanningTreeTest() {
        assertEquals(
            mapOf('A' to 'D', 'A' to 'B', 'B' to 'E', 'E' to 'C', 'C' to 'F'),
            graph.mwsp()
        )
    }
}
