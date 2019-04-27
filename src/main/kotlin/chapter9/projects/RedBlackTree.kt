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
//
class RedBlackTree : BinaryTree<Int>() {
    @Throws(IllegalArgumentException::class)
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
                } else if (value > current.data) {
                    current = current.right as RBNode?
                    if (current == null) {
                        parent.right = node
                        node.parent = parent
                        break
                    }
                } else throw IllegalArgumentException("element with $value is already exists")
            }
            insertAdjusting(node)
        }
    }

    private fun insertAdjusting(node: RBNode?) {
        if (node != root && node?.parent!!.color == RED) {
            val parent = node.parent!!
            val sibling = parent.getSibling()
            parent.color = BLACK
            when {
                sibling != null && sibling.color == RED -> {
                    parent.color = BLACK
                    sibling.color = BLACK
                    node.parent!!.parent?.color = RED
                    insertAdjusting(parent.parent)
                }
                parent == parent.parent?.left -> {
                    if (node == parent.right) {
                        rotateLeft(parent)
                        rotateRight(parent.parent!!.parent!!)
                    } else rotateRight(parent.parent!!)
                    (parent.right as RBNode?)?.color = RED
                }
                else -> {
                    if (node == parent.left) {
                        rotateRight(parent)
                        rotateLeft(parent.parent!!.parent!!)
                    } else rotateLeft(parent.parent!!)
                    (parent.left as RBNode?)?.color = RED
                }

            }
        }
        with(root as RBNode) { if (color == RED) color = BLACK }
    }

    override fun delete(key: Int): Node? {
        val elem = super.delete(key) as RBNode?
        elem?.let { deletionAdjusting(it) }
        return elem
    }

    private fun deletionAdjusting(elem: RBNode) {
        var node = elem as RBNode?
        while (node != root && isBlack(node)) {
            if (node!!.data < node.parent?.data) {
                var sibling = node.parent?.right as RBNode?
                if (isRed(sibling)) {
                    sibling!!.color = BLACK
                    node.parent!!.color = RED
                    rotateLeft(node.parent!!)
                    sibling = node.parent?.right as RBNode?
                }
                if (isBlack(sibling?.left as RBNode?) && isBlack(sibling?.right as RBNode?)) {
                    sibling!!.color = RED
                    node = node.parent
                } else if (sibling != null) {
                    if (isBlack(sibling.right as RBNode?)) {
                        (sibling.left as RBNode?)?.color = BLACK
                        sibling.color = RED
                        rotateRight(sibling)
                        sibling = node.parent?.right as RBNode?
                    }
                    sibling!!.color = node.parent!!.color
                    node.parent?.color = BLACK
                    (sibling.right as RBNode?)?.color = BLACK
                    rotateLeft(node.parent!!)
                    node = root as RBNode?
                } else {
                    node.color = BLACK
                    node = node.parent
                }
            } else {
                var sibling = node.parent?.left as RBNode?
                if (isRed(sibling)) {
                    sibling!!.color = BLACK
                    (node.parent as RBNode).color = RED
                    rotateRight(node.parent!!)
                    sibling = node.parent?.left as RBNode?
                }
                if (isBlack(sibling?.left as RBNode?) && isBlack(sibling?.right as RBNode?)) {
                    sibling!!.color = RED
                    node = node.parent
                } else if (sibling != null) {
                    if (isBlack(sibling.left as RBNode?)) {
                        (sibling.right as RBNode?)?.color = BLACK
                        sibling.color = RED
                        rotateLeft(sibling)
                        sibling = node.parent?.left as RBNode?
                    }
                    sibling!!.color = (node.parent as RBNode).color
                    node.parent?.color = BLACK
                    (sibling.left as RBNode?)?.color = BLACK
                    rotateRight(node.parent!!)
                    node = root as RBNode?
                } else {
                    node.color = BLACK
                    node = node.parent
                }
            }
        }
    }

    private fun rotateLeft(node: RBNode) {
        val right = node.right as RBNode?
        right?.parent = node.parent

        node.right = right?.left as RBNode?
        node.right?.let { (it as RBNode?)?.parent = node }

        right?.left = node
        node.parent = right

        if (right?.parent != null) {
            if (node == right.parent?.left) right.parent?.left = right
            else right.parent?.right = right
        } else root = right
    }

    private fun rotateRight(node: RBNode) {
        val left = node.left as RBNode?
        left?.parent = node.parent

        node.left = left?.right
        node.left?.let { (it.left as RBNode?)?.parent = node }

        left?.right = node
        node.parent = left

        if (left?.parent != null) {
            if (node == left.parent?.left) left.parent?.left = left
            else left.parent?.right = left
        } else root = left
    }

    private fun isRed(node: RBNode?) = node?.let { it.color == RED } ?: false

    private fun isBlack(node: RBNode?) = node?.let { it.color == BLACK } ?: false

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun getSibling() = when {
            this == root -> null
            this != parent?.left -> parent?.left as RBNode?
            else -> parent?.right as RBNode?
        }

        override fun display() {
            val color = if (color == BLACK) "B" else "R"
            print("$data($color)-{${parent?.data}}")
        }
    }

    enum class Color { RED, BLACK }
}
