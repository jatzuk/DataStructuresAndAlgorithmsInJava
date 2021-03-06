package chapter4

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 18.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PriorityQueue(maxSize: Int) : Queue(maxSize) {
    override fun remove(): Int {
        if (size == 0) {
            println("Queue is empty")
            return -1
        }
        var maxIndex = 0
        for (i in 0 until size) if (array[i] > array[maxIndex]) maxIndex = i

        val elem = array[maxIndex]

        for (i in maxIndex until size - 1) array[i] = array[i + 1]
        rear--
        size--
        return elem
    }

    fun peekMin() = array[size - 1]
}
