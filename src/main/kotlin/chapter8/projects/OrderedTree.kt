package chapter8.projects

import chapter8.BinaryTree
import chapter8.DefinitelyNotABinarySearchTree
import java.util.*

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

class OrderedTree(chars: CharArray) : DefinitelyNotABinarySearchTree<Char>() {
    init {
        if (chars.isNotEmpty()) recursivelyFill(chars) // dfsFill(chars)
    }

    private fun dfsFill(chars: CharArray) {
        var ptr = 0
        val queue: Queue<BinaryTree<Char>.Node> = LinkedList()
        root = Node(chars[ptr++])
        with(queue) {
            offer(root)
            while (ptr < chars.size) {
                val node = queue.poll()
                node.left = Node(chars[ptr++])
                offer(node.left)
                if (ptr < chars.size) {
                    node.right = Node(chars[ptr++])
                    offer(node.right)
                } else break
            }
        }
    }

    private fun recursivelyFill(chars: CharArray) {
        root = insertNode(1, chars)
    }

    private fun insertNode(position: Int, chars: CharArray): BinaryTree<Char>.Node? {
        return if (position > chars.size) null
        else Node(chars[position - 1]).apply {
            left = insertNode(2 * position, chars)
            right = insertNode(2 * position + 1, chars)
        }
    }
}
