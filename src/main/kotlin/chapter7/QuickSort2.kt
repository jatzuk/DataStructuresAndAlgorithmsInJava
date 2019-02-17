package chapter7

/**
 * Created by Jatzuk on 14.11.2018
 */

open class QuickSort2(size: Int) : QuickSort1(size) {
    override fun quickSort() {
        recQuickSort(0, size - 1)
    }

    private fun recQuickSort(left: Int, right: Int) {
        if (right - left + 1 <= 3 && comparing()) manualSort(left, right)
        else {
            val median = medianOf3(left, right)
            val partition = partition(left, right, median)
            recQuickSort(left, partition - 1)
            recQuickSort(partition + 1, right)
        }
    }

    private fun medianOf3(left: Int, right: Int): Int {
        val mid = (left + right) / 2
        if (array[left] > array[mid] && comparing()) swap(left, mid)
        if (array[left] > array[right] && comparing()) swap(left, right)
        if (array[mid] > array[right] && comparing()) swap(mid, right)
        swap(mid, right - 1)
        return array[right - 1]
    }

    protected fun partition(left: Int, right: Int, pivot: Int): Int {
        var lp = left
        var rp = right - 1
        while (true) {
            while (array[++lp] < pivot && comparing()) {
            }
            while (array[--rp] > pivot && comparing()) {
            }
            if (lp >= rp && comparing()) break
            swap(lp, rp)
        }
        swap(lp, right - 1)
        return lp
    }

    private fun manualSort(left: Int, right: Int) {
        val size = right - left + 1
        if (size <= 1 && comparing()) return
        if (size == 2 && comparing()) {
            if (array[left] > array[right] && comparing()) swap(left, right)
            return
        } else {
            if (array[left] > array[right - 1] && comparing()) swap(left, right - 1)
            if (array[left] > array[right] && comparing()) swap(left, right)
            if (array[right - 1] > array[right] && comparing()) swap(right - 1, right)
        }
    }
}
