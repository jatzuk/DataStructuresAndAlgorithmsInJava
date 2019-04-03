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
                        adjustAfterInsertion(node)
                        return
                    }
                } else {
                    current = current.right as RBNode?
                    if (current == null) {
                        parent.right = node
                        node.parent = parent
                        adjustAfterInsertion(node)
                        return
                    }
                }
            }
        }
    }

    private fun adjustAfterInsertion(node: RBNode?) {
        if (node != root && node?.parent!!.isRed()) {
            val parent = node.parent!!
            val sibling = parent.getSibling()
            if (sibling != null && sibling.isRed()) {
                parent.color = BLACK
                sibling.color = BLACK
                node.getGrandparent()?.color = RED
                adjustAfterInsertion(parent.parent)
            } else if (parent == parent.parent?.left) { // left
                if (node == parent.right) rotateRight(parent.parent)
                rotateRight(parent.parent!!)
            } else if (parent == parent.parent?.right) { // right
                if (node == parent.left) rotateLeft(parent.parent)
                rotateLeft(parent.parent!!)
            }
        }

        with(root as RBNode) { if (isRed()) color = BLACK }
    }

    private fun rotateLeft(node: RBNode?) {
        if (node != root as RBNode) {
            node?.let {
                val subtree = (it.right as RBNode).apply {
                    color = BLACK
                    parent = it.parent
                    left = it
                    it.color = RED
                    it.left = null // del ?
                    it.right = null // del ?
                }
                it.parent!!.right = subtree
            }
        } else {
            val newRoot = node.right
            val rootSibling = newRoot?.left
            val subtree = (root as RBNode).apply {
                color = RED
                this.right = rootSibling
                this.parent = newRoot as RBNode
            }
            root = newRoot!!
            newRoot.left = subtree
        }
    }

    private fun rotateRight(node: RBNode?) {

    }

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun isRed() = color == RED

        fun isBlack() = color == BLACK

        fun getSibling(): RBNode? {
            return if (this == root /*|| this.parent == null*/) null
            else {
                return if (this != parent?.left) parent?.left as RBNode?
                else parent?.right as RBNode?
            }
        }

        fun getGrandparent() = parent!!.parent

        override fun display() {
            val color = if (isBlack()) "B" else "R"
            print("$data($color)")
        }
    }

    enum class Color { RED, BLACK }
}
