package chapter8.projects

import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 19.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class BalancedBinaryTreeTest {
    @Test
    fun balancedTreeAFTest() {
        BalancedBinaryTree(('A'..'F').toList().toCharArray()).displayTree()
    }

    @Test
    fun balancedTreeAETest() {
        BalancedBinaryTree(('A'..'E').toList().toCharArray()).displayTree()
    }

    @Test
    fun balancedTreeALTest() {
        BalancedBinaryTree(('A'..'L').toList().toCharArray()).displayTree()
    }
}
