package chapter12

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

class HeapSort(size: Int) : Heap(size) {
    public override var currentSize = 0

    fun heapSort() {
        for (i in array.size / 2 - 1 downTo 0) trickleDown(i)
        val size = currentSize
        for (i in array.size - 1 downTo 0) insertAt(i, remove()!!)
        currentSize = size
    }

    fun insertAt(index: Int, node: Node) {
        array[index] = node
    }

    @Throws(UnsupportedOperationException::class)
    override fun insert(key: Int): Boolean {
        throw UnsupportedOperationException(
            "operation insert(key: Int) is not supported, use insertAt(index: Int, node: Node)"
        )
    }

//    @Throws(UnsupportedOperationException::class)
//    override fun trickleUp(position: Int) {
//        throw UnsupportedOperationException("operation trickleUp(position: Int) is not supported")
//    }

    fun displayArray() {
        repeat(array.size) { print("${array[it]?.data} ") }
        println()
    }
}
