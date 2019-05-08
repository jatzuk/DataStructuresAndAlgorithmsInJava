package chapter11

import org.junit.Test
import java.lang.Math.random

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 05.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashTest {
    private val tableSize = 13
    private val table = Hash(tableSize)

    @Test
    fun hashTableTest() {
        with(table) {
            repeat(6) { insert(AbstractHash.DataItem((random() * 10 * tableSize).toInt())) }
            displayTable()
        }
    }

    @Test
    fun quadraticProbingTest() {
        with(table) {
            repeat(10) { quadraticProbing(AbstractHash.DataItem(((random() * 10 * tableSize).toInt()))) }
            displayTable()
        }
    }
}
