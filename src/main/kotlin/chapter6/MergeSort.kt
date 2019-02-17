package chapter6

import chapter2.HighArray

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava
 *        by Jatzuk on 24.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class MergeSort(maxSize: Int) : HighArray(maxSize) {
    fun mergeSort() {
        val workSpace = IntArray(size)
        recMergeSort(workSpace, 0, size - 1)
    }

    private fun recMergeSort(workSpace: IntArray, lowerBound: Int, upperBound: Int) {
        if (lowerBound == upperBound) return
        val mid = (lowerBound + upperBound) / 2
        recMergeSort(workSpace, lowerBound, mid)
        recMergeSort(workSpace, mid + 1, upperBound)
        merge(workSpace, lowerBound, mid + 1, upperBound)
    }

    private fun merge(workSpace: IntArray, lowPtr: Int, highPtr: Int, upperBound: Int) {
        val mid = highPtr - 1
        val n = upperBound - lowPtr + 1
        var lp = lowPtr
        var hp = highPtr
        var j = 0

        while (lp <= mid && hp <= upperBound) {
            if (array[lp] < array[hp]) workSpace[j++] = array[lp++]
            else workSpace[j++] = array[hp++]
        }

        while (lp <= mid) workSpace[j++] = array[lp++]
        while (hp <= upperBound) workSpace[j++] = array[hp++]
        for (i in 0 until n) array[lowPtr + i] = workSpace[i]
    }
}
