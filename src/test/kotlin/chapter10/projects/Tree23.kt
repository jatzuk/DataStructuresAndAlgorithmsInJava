package chapter10.projects

import org.junit.Before
import org.junit.Test

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

class Tree23Test {
    private val tree = Tree23()

    @Before
    fun setUp() {
        repeat(9) { tree.insert((it + 1) * 10) }
        tree.insert(9)
    }

    @Test
    fun splitTest() {
        tree.displayTree()
    }
}
