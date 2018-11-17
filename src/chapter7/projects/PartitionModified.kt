package chapter7.projects

import chapter2.HighArray

/**
 * Created by Jatzuk on 17.11.2018
 */

class PartitionModified(size: Int) : HighArray(size) {
    fun partition(left: Int, right: Int): Int {
        var lp = left - 1
        var rp = right

        while (true) {
            while (array[++lp] < array[right]) {
            }
            while (rp > 0 && array[--rp] > array[right]) {
            }
            if (lp >= rp) break
            swap(lp, rp)
        }
        swap(lp, right)
        return lp
    }

    private fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}
