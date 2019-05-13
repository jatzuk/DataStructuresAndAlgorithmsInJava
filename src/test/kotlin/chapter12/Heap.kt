package chapter12

import org.junit.Before
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

    @Before
    fun setUp() {
        with(heap) {
            Heap.Order.ASCENDING.changeEncapsulatedProperty()
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
        }
    }

    @Test
    fun heapTest() {
        with(heap) {
            displayHeap()
            insert(53)
            displayHeap()
            remove()
            displayHeap()
        }
    }

    private fun Heap.Order.changeEncapsulatedProperty() {
        Heap::class.java.getDeclaredField("order").apply {
            isAccessible = true
            set(heap, this@changeEncapsulatedProperty)
        }
    }
}
