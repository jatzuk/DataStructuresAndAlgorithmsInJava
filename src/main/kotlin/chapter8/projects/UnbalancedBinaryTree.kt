package chapter8.projects

import chapter8.BinaryTree
import chapter8.DefinitelyNotABinarySearchTree

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 18.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class UnbalancedBinaryTree(chars: CharArray) : DefinitelyNotABinarySearchTree<Char>() {
    init {
        with(arrayOfNulls<BinaryTree<Char>.Node>(chars.size - 1)) {
            repeat(size) { i ->
                this[i] = Node('+').apply { right = Node(chars[chars.size - 1 - i]) }
                if (root == null) root = this[i]
                else this[i - 1]?.left = this[i]
            }
            this[size - 1]?.left = Node(chars[0])
        }
    }
}
