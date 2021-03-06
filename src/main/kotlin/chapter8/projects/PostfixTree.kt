package chapter8.projects

import chapter8.BinaryTree
import chapter8.DefinitelyNotABinarySearchTree
import java.util.*

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 22.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PostfixTree(expression: CharArray) : DefinitelyNotABinarySearchTree<Char>() {
    init {
        with(ArrayDeque<BinaryTree<Char>.Node>()) {
            repeat(expression.size) {
                val char = expression[it]
                val node = Node(char)
                if (char == '+' || char == '-' || char == '*' || char == '/') {
                    node.apply {
                        right = pop()
                        left = pop()
                    }
                }
                push(node)
            }
            root = pop()
        }
    }

    override fun inOrder(node: BinaryTree<Char>.Node?) {
        node?.let {
            print("(")
            inOrder(node.left)
            node.display()
            inOrder(node.right)
            print(")")
        }
    }
}
