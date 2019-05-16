package chapter12

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

class HeapTossTest {
    private val heapSize = 10
    private val heap = HeapToss(heapSize)

    @Before
    fun setUp() {
        with(heap) {
            repeat(heapSize) { toss((random() * 100).toInt()) }
        }
    }

    @Test
    fun heapTossTest() {
        with(heap) {
            displayHeap()
            restoreHeap()
            displayHeap()
        }
    }
}
