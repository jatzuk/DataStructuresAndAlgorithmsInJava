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
        if (node != root) {
            val parent = node!!.parent!!
            if (parent.isRed()) {
                val sibling = parent.getSibling()
                if (sibling != null && sibling.isRed()) {
                    parent.color = BLACK
                    sibling.color = BLACK
                    node.getGrandparent()?.color = RED
                    adjustAfterInsertion(node.getGrandparent())
                }
            } else if (parent == parent.parent?.left) { // left

            } else if(parent == parent.parent?.right) { // right
//                with(parent) {
//                    if (node == left) rotateLeft(this)
//                    color = BLACK
//                    parent.color = RED
//                    rotateLeft(parent)
//                }
//                if (node == parent.left) rotateLeft(parent)
//                parent.color = BLACK
//                parent.parent!!.color = RED
                println("FFF ${parent.data}")
                rotateLeft(parent)
            }
        }

        with(root as RBNode) { if (isRed()) color = BLACK }
    }

    private fun rotateLeft(node: RBNode) {
        println("node.right: ${node.right?.data}")
        println("node: ${node.data}")

        val subtree = node.right
        println("building subtree: ${subtree?.data}")
        val sibling = node.right
        println("saving sibling: ${sibling!!.data}")
        subtree?.left = sibling
        println("subtree left: ${subtree?.left}")
        node.right = subtree
    }

    private fun rotateRight(node: RBNode) {
    }

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun isRed() = color == RED

        fun isBlack() = color == BLACK

        fun getSibling(): RBNode? {
            return if (this == root /*|| this.parent == null*/) null
            else parent?.left as RBNode? ?: parent?.right as RBNode?
        }

        fun getGrandparent() = parent!!.parent

        override fun display() {
            val color = if (isBlack()) "B" else "R"
            print("$data($color)")
        }
    }

    enum class Color { RED, BLACK }
}
