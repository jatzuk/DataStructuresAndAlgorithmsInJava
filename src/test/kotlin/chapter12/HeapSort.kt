package chapter12

import chapter12.Heap.Node
import org.junit.Test
import java.lang.Math.random

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 12.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HeapSortTest {
    private val heapSize = 10
    private val heap = HeapSort(heapSize)

    @Test
    fun heapSortTest() {
        with(heap) {
            repeat(heapSize) {
                insertAt(it, Node((random() * 99 + 1).toInt()))
                currentSize++
            }
            displayArray()
            for (i in heapSize / 2 - 1 downTo 0) trickleDown(i)
            print("Heap: ")
            displayArray()
            displayHeap()
            for (i in heapSize - 1 downTo 0) {
                val biggestNode = remove()
                insertAt(i, biggestNode!!)
            }
            print("Sorted: ")
            displayArray()
        }
    }
}
