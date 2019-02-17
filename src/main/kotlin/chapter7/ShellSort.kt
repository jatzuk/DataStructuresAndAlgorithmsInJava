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

class ShellSort(size: Int) : HighArray(size) {
    fun shellSort() {
        var h = 1
        while (h <= size / 3) h *= 3 + 1

        while (h > 0) {
            for (i in h until size) {
                val tmp = array[i]
                var inner = i
                while (inner > h - 1 && array[inner - h] >= tmp) {
                    array[inner] = array[inner - h]
                    inner -= h
                }
                array[inner] = tmp
            }
            h = (h - 1) / 3
        }
    }
}
