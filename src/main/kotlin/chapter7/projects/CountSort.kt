package chapter7.projects

import java.util.*

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava
 *        by Jatzuk on 17-Feb-19
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

fun main() {
    val array = (10 downTo 0).toMutableList().toIntArray()
    val bucket = IntArray(array.size + 1)

    for (i in 0 until bucket.size - 1) bucket[array[i]]++

    var k = 0
    for (i in 0 until bucket.size) for (j in 0 until bucket[i]) array[k++] = i
    println(Arrays.toString(array))
}
