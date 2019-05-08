package chapter11

import org.junit.Before
import org.junit.Test
import java.lang.Math.random

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

class HashChainTest {
    private val hashTableSize = 20
    private val hashChain = HashChain(hashTableSize)
    private val keysPerCell = 100

    @Before
    fun setUp() {
        repeat(hashTableSize) {
            hashChain.insert((random() * keysPerCell * hashTableSize).toInt())
        }
    }

    @Test
    fun hashChainTest() {
        with(hashChain) {
            insert(10)
            displayTable()
            delete(10)
            println("--------------")
            displayTable()
        }
    }
}
