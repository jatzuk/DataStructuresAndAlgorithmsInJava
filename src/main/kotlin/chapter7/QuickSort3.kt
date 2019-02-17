package chapter7

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 14.11.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class QuickSort3(size: Int) : QuickSort2(size) {
    override fun quickSort() {
        recQuickSort(0, size - 1)
//        insertionSort(0, size - 1)
    }

    private fun recQuickSort(left: Int, right: Int) {
        if (right - left + 1 < 10) insertionSort(left, right)
        else {
            val median = medianOf3(left, right)
            val partition = partition(left, right, median)
            recQuickSort(left, partition - 1)
            recQuickSort(partition + 1, right)
        }
    }

    private fun medianOf3(left: Int, right: Int): Int {
        val mid = (left + right) / 2
        if (array[left] > array[mid]) swap(left, mid)
        if (array[left] > array[right]) swap(left, right)
        if (array[mid] > array[right]) swap(mid, right)
        swap(mid, right - 1)
        return array[right - 1]
    }

    private fun insertionSort(left: Int, right: Int) {
        for (i in left + 1..right) {
            val tmp = array[i]
            var j = i
            while (j > left && array[j - 1] >= tmp) array[j] = array[j-- - 1]
            array[j] = tmp
        }
    }
}
