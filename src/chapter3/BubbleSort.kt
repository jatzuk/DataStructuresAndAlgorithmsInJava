package chapter3

import chapter2.HighArray

/**
 * Created by Jatzuk on 10.09.2018
 */

class BubbleSort(max: Int) : HighArray(max) {
    private var swapped = false

    fun bubbleSort() {
        swapped = false
        mainLoop@ for (i in size - 1 downTo 1) {
            swapped = false
            for (j in 0 until i) if (array[j] > array[j + 1]) swap(j, j + 1)
            if (!swapped) break@mainLoop
        }
    }

    fun cocktailShakerSort() {
        swapped = false
        mainLoop@ for (i in size - 1 downTo 1) {
            swapped = false
            for (j in 0 until i) if (array[j] > array[j + 1]) swap(j, j + 1)
            for (j in i - 1 downTo 1) if (array[j] < array[j - 1]) swap(j, j - 1)
            if (!swapped) break@mainLoop
        }
    }

    fun oddEvenSort() {
        swapped = false
        do {
            swapped = false
            for (i in 1 until size - 1 step 2) if (array[i] > array[i + 1]) swap(i, i + 1)
            for (i in 0 until size - 1 step 2) if (array[i] > array[i + 1]) swap(i, i + 1)
        } while (swapped)
    }

    private fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
        swapped = true
    }
}
