package chapter12

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

class HeapToss(size: Int) : Heap(size) {
    fun toss(key: Int): Boolean {
        return if (currentSize == array.size) false
        else {
            array[currentSize++] = Node(key)
            true
        }
    }

    fun restoreHeap() {
        for (i in array.size / 2 - 1 downTo 0) trickleDown(i)
    }
}
