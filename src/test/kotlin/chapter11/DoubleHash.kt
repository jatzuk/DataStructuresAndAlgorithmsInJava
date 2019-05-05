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

class DoubleHashTest {
    private val table = DoubleHash(13)

    @Test
    fun doubleHashTest() {
        with(table) {
            repeat(6) {
                val key = (random() * 2 * size).toInt()
                insert(key, DataItem(key))
            }
            displayTable()
        }
    }
}
