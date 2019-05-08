package chapter11.projects

import chapter11.AbstractHash
import org.junit.Before
import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 08.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashTableStringTest {
    private val tableSize = 13
    private val table = HashTableString(tableSize)

    @Before
    fun setUp() {
        with(table) {
            insert(AbstractHash.DataItem("come"))
            insert(AbstractHash.DataItem("get"))
            insert(AbstractHash.DataItem("give"))
            insert(AbstractHash.DataItem("go"))
            insert(AbstractHash.DataItem("keep"))
            insert(AbstractHash.DataItem("let"))
            insert(AbstractHash.DataItem("make"))
            insert(AbstractHash.DataItem("put"))
            insert(AbstractHash.DataItem("seem"))
            insert(AbstractHash.DataItem("take"))
            insert(AbstractHash.DataItem("be"))
            insert(AbstractHash.DataItem("do"))
            insert(AbstractHash.DataItem("have"))
//            insert(AbstractHash.DataItem("OVERFLOW"))
        }
    }

    @Test
    fun hashTableStringTest() {
        table.displayTable()
    }
}
