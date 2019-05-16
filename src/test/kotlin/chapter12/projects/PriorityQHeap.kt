package chapter12.projects

import org.junit.Before
import org.junit.Test
import java.lang.Math.random

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

class PriorityQHeapTest {
    private val queueSize = 10
    private val queue = PriorityQHeap(queueSize)

    @Before
    fun setUp() {
        with(queue) {
            repeat(queueSize) { insert((random() * 100).toInt()) }
        }
    }

    @Test
    fun priorityQHeapTest() {
        with(queue) {
            repeat(queueSize / 2) {
                displayHeap()
                peek()
            }
        }
    }
}
