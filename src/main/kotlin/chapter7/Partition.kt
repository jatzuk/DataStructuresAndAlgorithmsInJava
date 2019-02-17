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

class Partition(size: Int) : HighArray(size) {
    fun partition(left: Int, right: Int, pivot: Int): Int {
        var lp = left - 1
        var rp = right + 1
        while (true) {
            while (lp < right && array[++lp] < pivot) {
            }
            while (rp > left && array[--rp] > pivot) {
            }
            if (lp >= rp) break
            else swap(lp, rp)
        }
        return lp
    }

    private fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}
