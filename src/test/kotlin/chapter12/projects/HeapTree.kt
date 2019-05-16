package chapter12.projects

import org.junit.Before
import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 16.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PriorityQTreeTest {
    private val heap = PriorityQTree()

    @Before
    fun setUp() {
        with(heap) {
            insert(5)
            insert(3)
            insert(14)
            insert(10)
            insert(17)
        }
    }

    @Test
    fun priorityQTreeTest() {
        with(heap) {
            displayTree()
            peek()
            displayTree()
        }
    }
}
