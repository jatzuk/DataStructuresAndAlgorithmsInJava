package chapter6

import chapter6.ValuesHolder.count
import chapter6.ValuesHolder.length

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 23.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

object ValuesHolder {
    val arr = "kotlin".toCharArray()
    val length = arr.size
    var count = 0
}

fun anagram(size: Int = ValuesHolder.length) {
    if (size == 1) return
    for (i in 0 until size) {
        anagram(size - 1)
        if (size == 2) displayWord()
        rotate(size)
    }
}

fun rotate(size: Int) {
    val pos = ValuesHolder.length - size
    val ch = ValuesHolder.arr[pos]
    for (i in pos + 1 until length) ValuesHolder.arr[i - 1] = ValuesHolder.arr[i]
    ValuesHolder.arr[length - 1] = ch
}

fun displayWord() {
    if (count < 99) print(" ")
    if (count < 9) print(" ")
    print("${++count}.")
    for (i in 0 until length) print(ValuesHolder.arr[i])
    print(" ")
    if (count % 6 == 0) println()
}
