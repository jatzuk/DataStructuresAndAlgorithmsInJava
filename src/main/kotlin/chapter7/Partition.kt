package chapter7

import chapter2.HighArray

/**
 * Created by Jatzuk on 28.10.2018
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

fun main(args: Array<String>) {
    with(Partition(10)) {
        for (i in 0 until 10) insert((Math.random() * 99).toInt() + 1)
        display()
        val pivot = 50
        print("pivot: $pivot, ")
        val dex = partition(0, size - 1, pivot)
        println("Partition is at index: $dex")
        display()
    }
}