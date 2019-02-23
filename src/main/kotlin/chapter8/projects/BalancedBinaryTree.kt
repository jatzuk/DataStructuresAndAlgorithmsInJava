package chapter8.projects

import chapter8.BinaryTree

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

class BalancedBinaryTree(chars: CharArray) : BinaryTree<Char>() {
    init {
        val nodes = arrayOfNulls<BinaryTree<Char>.Node>(chars.size)
        repeat(chars.size) { i -> nodes[i] = Node(chars[i]) }
        var pairs = chars.size
        while (pairs > 1) {
            var fills = 0
            repeat(pairs) { i ->
                if (i and 1 == 1) {
                    with(Node('+')) {
                        left = nodes[i - 1]
                        right = nodes[i]
                        nodes[fills++] = this
                    }
                }
                if (i and 1 == 0 && i == pairs - 1) nodes[fills] = nodes[i]
            }
            pairs -= fills
        }
        root = nodes[0]
    }

    override fun find(key: Char): BinaryTree<Char>.Node? {
        throw NotImplementedError("operation is not supported")
    }

    override fun delete(key: Char): Boolean {
        throw NotImplementedError("operation is not supported")
    }

    override fun insert(value: Char) {
        throw NotImplementedError("operation is not supported")
    }
}
