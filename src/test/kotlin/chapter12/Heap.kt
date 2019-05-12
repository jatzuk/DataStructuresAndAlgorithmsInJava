package chapter12

import org.junit.Test

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

class HeapTest {
    private val heap = Heap(31)

    @Test
    fun heapTest() {
        with(heap) {
            insert(70)
            insert(40)
            insert(50)
            insert(20)
            insert(60)
            insert(100)
            insert(80)
            insert(30)
            insert(10)
            insert(90)
            displayHeap()
            insert(53)
            displayHeap()
            remove()
            displayHeap()
        }
    }
}
