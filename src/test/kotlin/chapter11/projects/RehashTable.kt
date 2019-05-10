package chapter11.projects

import chapter11.AbstractHash.DataItem
import org.junit.Test

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 11.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class RehashTableTest {
    private val tableSize = 15
    private val table = RehashTable(tableSize)
    private val array = arrayOf(26, 29, 65, 21, 23, 70, 89)

    @Test
    fun rehashTableTest() {
        with(table) {
            repeat(7) { insert(DataItem(array[it])) }
            displayTable()
            insert(DataItem(2))
            displayTable()
            repeat(6) { insert(DataItem(array[it] + 1)) }
            displayTable()
            insert(DataItem(100))
            displayTable()
        }
    }
}
