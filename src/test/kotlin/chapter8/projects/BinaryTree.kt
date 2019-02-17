package chapter8.projects

import org.junit.Test

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class BinaryTree1Test {
    @Test
    fun treeTest() {
        val sequence = "ABCDE"
        with(BinaryTree1()) {
            buildTreeFromChars(sequence)
            displayTree()
        }
    }
}
