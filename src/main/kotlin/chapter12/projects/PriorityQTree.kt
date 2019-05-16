package chapter12.projects

import chapter8.BinaryTree

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 16.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PriorityQTree : BinaryTree<Int>() {
    fun peek() = removeMax()

    private fun BinaryTree<Int>.removeMax(): Node? {
        var current = root
        while (current?.right != null) current = current.right
        return delete(current!!.data)
    }
}
