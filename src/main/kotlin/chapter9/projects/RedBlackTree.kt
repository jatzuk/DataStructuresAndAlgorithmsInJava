package chapter9.projects

import chapter8.BinaryTree
import chapter9.projects.RedBlackTree.Color.BLACK
import chapter9.projects.RedBlackTree.Color.RED

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 30.03.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class RedBlackTree : BinaryTree<Int>() {
    override fun insert(value: Int) {
        val node = RBNode(value)
        if (root == null) {
            root = node
            node.color = BLACK
        } else {
            var current = root as RBNode?
            var parent: RBNode
            while (true) {
                parent = current!!
                if (value < current.data) {
                    current = current.left as RBNode?
                    if (current == null) {
                        parent.left = node
                        node.parent = parent
                        break
                    }
                } else {
                    current = current.right as RBNode?
                    if (current == null) {
                        parent.right = node
                        node.parent = parent
                        break
                    }
                }
            }
            adjustTree(node)
        }
    }

    private fun adjustTree(node: RBNode?) {
        if (node != root && node?.parent!!.isRed()) {
            val parent = node.parent!!
            val sibling = parent.getSibling()
            if (sibling != null && sibling.isRed()) {
                parent.color = BLACK
                sibling.color = BLACK
                node.parent!!.parent?.color = RED
                adjustTree(parent.parent)
            } else if (parent == parent.parent?.left) { // left
                if (node == parent.right) {
                    rotateLeft(parent)
                    rotateRight(parent.parent!!.parent!!)
                } else rotateRight(parent.parent!!)
            } else if (parent == parent.parent?.right) { // right
                if (node == parent.left) {
                    rotateRight(parent)
                    rotateLeft(parent.parent!!.parent!!)
                } else rotateLeft(parent.parent!!)
            }
        }

        with(root as RBNode) { if (isRed()) color = BLACK }
    }

    private fun rotateLeft(node: RBNode) {
        with(node) {
            if (node != root) {
                val subtree = (right as RBNode).apply {
                    color = BLACK
                    parent = node.parent
                    left = node
                }
                color = RED
                right = null
                parent!!.right = subtree
                parent = subtree
            } else {
                val newRoot = right as RBNode
                newRoot.parent = null
                val sibling = newRoot.left as RBNode
                val subtree = (root as RBNode).apply {
                    color = RED
                    right = sibling
                    parent = newRoot
                }
                sibling.parent = subtree
                root = newRoot
                newRoot.left = subtree
            }
        }
    }

    private fun rotateRight(node: RBNode) {
        with(node) {
            if (this != root) {
                val subtree = (node.left as RBNode).apply {
                    color = BLACK
                    parent = node.parent
                    right = node
                }
                color = RED
                left = null
                parent!!.left = subtree
                parent = subtree
            } else {
                val newRoot = node.left as RBNode
                newRoot.parent = null
                val sibling = newRoot.right as RBNode
                val subtree = (root as RBNode).apply {
                    color = RED
                    left = sibling
                    parent = newRoot
                }
                sibling.parent = subtree
                root = newRoot
                newRoot.right = subtree
            }
        }
    }

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun isRed() = color == RED

        fun isBlack() = color == BLACK

        fun getSibling() = when {
            this == root /*|| this.parent == null*/ -> null
            this != parent?.left -> parent?.left as RBNode?
            else -> parent?.right as RBNode?
        }

        override fun display() {
            val color = if (isBlack()) "B" else "R"
            print("$data($color)-{${parent?.data}}")
        }
    }

    enum class Color { RED, BLACK }
}
