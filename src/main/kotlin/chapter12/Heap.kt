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

open class Heap(size: Int) {
    protected val array = arrayOfNulls<Node>(size)
    protected open var currentSize = 0

    open fun insert(key: Int): Boolean {
        return if (currentSize == array.size) false
        else {
            array[currentSize] = Node(key)
            trickleUp(currentSize++)
            true
        }
    }

    protected open fun trickleUp(position: Int) {
        var index = position
        var parent = (index - 1) / 2
        val bottom = array[index]

        while (index > 0 && array[parent]!!.data < bottom!!.data) {
            array[index] = array[parent]
            index = parent
            parent = (parent - 1) / 2
        }
        array[index] = bottom
    }

    fun remove(): Node? {
        if (currentSize == 0) return null
        val root = array[0]
        array[0] = array[--currentSize]
        trickleDown(0)
        return root
    }

    protected fun trickleDown(position: Int) {
        var index = position
        val top = array[index]

        while (index < currentSize / 2) {
            val leftChild = 2 * index + 1
            val rightChild = leftChild + 1
            val largerChild =
                if (rightChild < currentSize && array[leftChild]!! < array[rightChild]) rightChild
                else leftChild

            if (top!! >= array[largerChild]) break
            array[index] = array[largerChild]
            index = largerChild
        }
        array[index] = top
    }

    protected fun change(index: Int, value: Int): Boolean {
        if (index <= 0 || index >= currentSize) return false
        val oldValue = array[index]!!.data
        array[index]!!.data = value
        if (oldValue < value) trickleUp(index)
        else trickleDown(index)
        return true
    }

    fun displayHeap() {
        print("${this::class.java.simpleName}: ")
        repeat(currentSize) { i -> array[i]?.let { print("${it.data} ") } ?: print("-- ") }
        println()
        var blanks = 32
        var itemsPerRow = 1
        var column = 0
        var i = 0
        val dots = "......................"
        println("$dots$dots")

        while (currentSize > 0) {
            if (column == 0) repeat(blanks) { print(" ") }
            print(array[i]?.data)
            if (++i == currentSize) break
            if (++column == itemsPerRow) {
                blanks /= 2
                itemsPerRow *= 2
                column = 0
                println()
            } else repeat(blanks * 2 - 2) { print(" ") }
        }
        println("\n$dots$dots")
    }

    fun isEmpty() = currentSize == 0

    class Node(var data: Int) : Comparable<Node?> {
        override fun compareTo(other: Node?) = other?.let { data.compareTo(it.data) } ?: 1
    }
}
