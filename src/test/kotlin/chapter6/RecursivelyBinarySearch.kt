package chapter6

import chapter6.RecursivelyBinarySearch.arr
import org.junit.Assert.assertEquals
import org.junit.Test

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

class RecursivelyBinarySearchTest {
    @Test
    fun recursivelyBinarySearchTest() {
        assertEquals(1, binarySearchRecursively(2, 0, arr.size - 1))
    }
}
