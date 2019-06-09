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

class FloydAlgorithmTest {
    private val graph = FloydAlgorithm(20)

    @Before
    fun setUp() {
        with(graph) {
            repeat(5) { addVertex((it + 65).toChar()) }
            addEdge(0, 1, 50)
            addEdge(0, 3, 80)
            addEdge(1, 2, 60)
            addEdge(1, 3, 90)
            addEdge(2, 4, 40)
            addEdge(3, 2, 20)
            addEdge(3, 4, 70)
            addEdge(4, 1, 50)
        }
    }

    @Test
    fun floydAlgorithmTest() {
        val matrix = graph.floydAlgorithm()
        graph.displayMatrix(matrix)

    }
}
