package chapter2

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 06.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class HighArray(max: Int) {
    val array = IntArray(max) { 0 }
    var size = 0

    //    changed return type to Int for ex 2.3
    open fun find(key: Int): Int {
        for (i in 0 until size) if (array[i] == key) return i
        return -1
    }

    open fun insert(value: Int) {
        array[size++] = value
    }

    open fun delete(value: Int): Boolean {
        val k = find(value)
        return if (k == -1) false
        else {
            for (i in k until size - 1) array[i] = array[i + 1]
            size--
            true
        }
    }

    fun display() {
        for (i in 0 until size) print("${array[i]} ")
        println()
    }

    fun getMax(): Int {
        if (size == 0) return -1
        var max = Integer.MIN_VALUE
        for (i in 0 until size) if (array[i] > max) max = array[i]
        return max
    }

    fun removeMax(): Int {
        val max = getMax()
        if (max != -1) delete(max)
        return max
    }

    fun clear() {
        while (size-- > 1) array[size] = 0
    }

    fun noDumps() {
        if (size == 1 || size == 0) return

        for (i in 0 until size) {
            var min = i
            for (j in i + 1 until size) if (array[j] < array[min]) min = j
            if (min != i) {
                val tmp = array[i]
                array[i] = array[min]
                array[min] = tmp
            }
        }

        var j = 0
        for (i in 1 until size) if (array[i] > array[i - 1]) array[j++] = array[i]
        size -= j + 1
    }

    operator fun get(index: Int): Int = array[index]
}
