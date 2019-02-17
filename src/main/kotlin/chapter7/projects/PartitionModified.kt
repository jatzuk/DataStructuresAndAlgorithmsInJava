package chapter7.projects

import chapter2.HighArray

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.11.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PartitionModified(size: Int) : HighArray(size) {
    fun partition(left: Int, right: Int, pivot: Int = right): Int {
        var lp = left - 1
        var rp = right

        while (true) {
            while (array[++lp] < array[pivot]) {
            }
            while (rp > 0 && array[--rp] > array[pivot]) {
            }
            if (lp >= rp) break
            swap(lp, rp)
        }
        swap(lp, right)
        return lp
    }

    fun median(left: Int, right: Int): Int {
        val mid = size / 2
        if (right - left <= 0) return array[mid]
        val partition = partition(left, right)
        return when {
            partition == array[mid] -> partition
            partition < array[mid] -> median(partition + 1, right)
            else -> median(left, partition - 1)
        }
    }

    private fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}
