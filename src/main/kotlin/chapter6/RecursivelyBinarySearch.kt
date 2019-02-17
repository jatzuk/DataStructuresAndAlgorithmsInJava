package chapter6

import chapter6.RecursivelyBinarySearch.arr

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava
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

object RecursivelyBinarySearch {
    val arr = arrayOf(1, 2, 3, 4)
}

fun binarySearchRecursively(searchKey: Int, lowerBound: Int, upperBound: Int): Int {
    val cur = (lowerBound + upperBound) / 2
    return if (arr[cur] == searchKey) cur
    else if (lowerBound > upperBound) -1
    else {
        if (arr[cur] < searchKey) binarySearchRecursively(searchKey, cur + 1, upperBound)
        else binarySearchRecursively(searchKey, lowerBound, cur - 1)
    }
}
