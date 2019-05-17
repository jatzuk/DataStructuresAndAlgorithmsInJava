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

class GraphTest {
    private val graph = Graph(20)

    @Before
    fun setUp() {
        repeat(5) { graph.addVertex((65 + it).toChar()) }
        with(graph) {
            addEdge(0, 1)
            addEdge(1, 2)
            addEdge(0, 3)
            addEdge(3, 4)
        }
    }

    @Test
    fun graphTest() {
        print("Visits: ")
        graph.dfs()
    }
}
