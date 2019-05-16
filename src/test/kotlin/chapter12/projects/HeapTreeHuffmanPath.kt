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
 * ex 5 test
 */

class HeapTreeHuffmanPathTest {
    private val heap = HeapTreeHuffmanPath()

    @Before
    fun setUp() {
        with(heap) {
            repeat(10) { insert((random() * 100).toInt()) }
        }
    }

    @Test
    fun heapTreeHuffmanPathTest() {
        with(heap) {
            displayHeapTree()
        }
    }
}
