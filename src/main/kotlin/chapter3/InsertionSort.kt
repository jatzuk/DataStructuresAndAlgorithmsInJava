package chapter3

import chapter2.HighArray

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 10.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class InsertionSort(max: Int) : HighArray(max) {
    fun insertionSort() {
        for (i in 1 until size) {
            val tmp = array[i]
            var j = i
            while (j > 0 && array[j - 1] >= tmp) swap(j, j-- - 1)
            array[j] = tmp
        }
    }

    fun selectionSort() {
        for (i in 0 until size - 1) {
            var min = i
            var j = i + 1
            while (j < size) if (array[j++] < array[min]) min = j - 1
            swap(i, min)
        }
    }

    fun insertionSortStatistics() {
        var copies = 0
        var comparisons = 0
        for (i in 1 until size) {
            val tmp = array[i]
            var j = i
            while (j > 0 && array[j - 1] >= tmp) {
                swap(j, j-- - 1)
                comparisons += 2
                copies += 3
            }
            array[j] = tmp
            copies += 2
        }

        println("copies: $copies")
        println("comparisons: $comparisons")
    }

    fun swap(a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }

    fun median(): StringBuilder {
        val flag = (size % 2 == 0)
        val x = size / 2
        val result = StringBuilder()
        if (!flag) result.append(array[x])
        else result.append(array[x - 1]).append(" ").append(array[x])
        return result
    }

    fun noDups() {
        var end = 0
        var p = 1
        for (i in 1 until size) {
            if (array[i] <= array[i - 1]) end++
            else array[p++] = array[i]
        }
        size -= end
        display()
    }

    fun insertionSortNoDups() {
        var misses = 0
        for (i in 1 until size) {
            var tmp = array[i]
            var j = i
            while (j > 0 && array[j - 1] >= tmp) {
                if (array[j - 1] == tmp && tmp > -1) {
                    tmp = -1
                    misses++
                }
                swap(j, j-- - 1)
            }
            array[j] = tmp
        }

        for (i in 0 until size - misses) array[i] = array[i + misses]
        size -= misses
    }
}
