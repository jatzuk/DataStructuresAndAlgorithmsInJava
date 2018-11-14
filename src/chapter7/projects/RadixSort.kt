package chapter7.projects

import chapter2.HighArray

/**
 * Created by Jatzuk on 14.11.2018
 */

class RadixSort(size: Int) : HighArray(size) {
    fun radixSort() {
        val radix = 10
        val bucket = Array(radix) { ArrayList<Int>(size) }
        var pos = 1
        var max = Int.MIN_VALUE

        do {
            for (i in array) {
                val tmp = i / pos
                bucket[tmp % radix].add(i)
                if (pos == 1 && tmp > max) max = tmp
            }
            var k = 0
            for (i in 0 until radix) {
                for (j in bucket[i]) array[k++] = j
                bucket[i].clear()
            }
            pos *= radix
        } while (pos < max)
    }
}
