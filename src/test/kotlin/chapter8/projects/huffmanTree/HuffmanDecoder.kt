package chapter8.projects.huffmanTree

import chapter8.projects.huffmanTree.HuffmanEncoder.Companion.PATH
import org.junit.Assert.assertEquals
import org.junit.Test

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HuffmanDecoderTest {
    @Test
    fun huffmanDecoderTest() {
        assertEquals("susie says it is easy", HuffmanDecoder(PATH).message)
    }
}
