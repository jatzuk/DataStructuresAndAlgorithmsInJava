package chapter11.projects

import org.junit.Assert.assertEquals
import org.junit.Test

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 10.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashFoldingTest {
    @Test
    fun hashFoldingTest() {
        assertEquals(368, HashFolding(1000).hashFun(123456789))
    }
}
