package chapter11.projects

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.Math.random

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 12.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashTreeTest {
    private val hashTableSize = 13
    private val array = generateSequence(1, Int::inc)
        .takeWhile { it < hashTableSize * 3 }
        .toList()
    private val table = HashTree(hashTableSize)

    @Test
    fun hashTreeLinearInsertsTest() {
        with(table) {
            repeat(array.size) { insert(array[it]) }
            displayTable()
            assertEquals(34, delete(34))
            displayTable()
        }
    }

    @Test
    fun hashTreeRandomInsertsTest() {
        val inserts = MutableList(array.size) { -1 }
        with(table) {
            repeat(array.size * 2) {
                val n = (random() * 99 + 1).toInt()
                if (!inserts.contains(n)) {
                    insert(n)
                    inserts.add(n)
                }
            }
            displayTable()
        }
    }
}
