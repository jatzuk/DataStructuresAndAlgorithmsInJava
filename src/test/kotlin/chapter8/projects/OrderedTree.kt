package chapter8.projects

import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 21.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class OrderedTreeTest {
    @Test
    fun orderedTreeAJTest() {
        OrderedTree(('A'..'J').toList().toCharArray()).displayTree()
    }

    @Test
    fun orderedTreeAITest() {
        OrderedTree(('A'..'I').toList().toCharArray()).displayTree()
    }

    @Test
    fun orderedTreeAKTest() {
        OrderedTree(('A'..'K').toList().toCharArray()).displayTree()
    }

    @Test
    fun orderedTreeAZTest() {
        OrderedTree(('A'..'Z').toList().toCharArray()).displayTree()
    }
}
