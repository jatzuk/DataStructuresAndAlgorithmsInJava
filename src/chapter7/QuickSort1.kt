package chapter7

import chapter2.HighArray

/**
 * Created by Jatzuk on 28.10.2018
 */

open class QuickSort1(size: Int) : HighArray(size) {
    open fun quickSort() {
        recQuickSort(0, size - 1)
    }

    private fun recQuickSort(left: Int, right: Int) {
        if (right - left <= 0) return

        val pivot = array[right]
        val partition = partition(left, right, pivot)
        recQuickSort(left, partition - 1)
        recQuickSort(partition + 1, right)
    }

    private fun partition(left: Int, right: Int, pivot: Int): Int {
        var lp = left - 1
        var rp = right
        while (true) {
            while (array[++lp] < pivot) {
            }
            while (rp > 0 && array[--rp] > pivot) {
            }
            if (lp >= rp) break
            swap(lp, rp)
        }
        swap(lp, right)
        return lp
    }

    protected fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}
