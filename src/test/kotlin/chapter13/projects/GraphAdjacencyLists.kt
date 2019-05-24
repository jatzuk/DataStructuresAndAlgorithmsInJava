package chapter13.projects

import org.junit.Before
import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class GraphAdjacencyListsTest {
    private val size = 4
    private val graph = AdjacencyListGraph(size)

    @Before
    fun setUp() {
        repeat(size) { graph.addVertex((it + 65).toChar()) }
    }

    @Test
    fun dfsAdjacencyListsTest() {
        with(graph) {
            addEdge(0, 'B')
            addEdge(0, 'C')
            addEdge(0, 'D')
            addEdge(1, 'A')
            addEdge(1, 'D')
            addEdge(2, 'A')
            addEdge(3, 'A')
            addEdge(3, 'B')
            dfs()
        }
    }
}
