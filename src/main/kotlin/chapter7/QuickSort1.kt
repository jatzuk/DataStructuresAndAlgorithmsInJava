package chapter7

import chapter2.HighArray

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 28.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class QuickSort1(size: Int) : HighArray(size) {
    protected var copies = 0
        private set

    protected var comparisons = 0
        private set

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
        copies += 3
    }

    protected fun comparing(): Boolean {
        comparisons++
        return true
    }
}
