package chapter14.projects

import org.junit.Before
import org.junit.Test

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

class ReferenceGraphTest {
    private val graph = ReferenceGraph(20)

    @Before
    fun setUp() {
        with(graph) {
            repeat(8) { addVertex((it + 65).toChar()) }
            addEdge(0, 1)
            addEdge(0, 3)
            addEdge(1, 2)
            addEdge(1, 3)
            addEdge(2, 4)
            addEdge(3, 2)
            addEdge(3, 4)
            addEdge(4, 1)
        }
    }

    @Test
    fun referenceGraphTest() {
        graph.displayAdjustMatrix()
    }
}
