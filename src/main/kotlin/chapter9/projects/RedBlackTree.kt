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
            adjustTree(node)
        }
    }

    private fun adjustTree(node: RBNode?) {
        if (node != root && node?.parent!!.color == RED) {
            val parent = node.parent!!
            val sibling = parent.getSibling()
            parent.color = BLACK
            when {
                sibling != null && sibling.color == RED -> {
                    parent.color = BLACK
                    sibling.color = BLACK
                    node.parent!!.parent?.color = RED
                    adjustTree(parent.parent)
                }
                parent == parent.parent?.left -> {
                    if (node == parent.right) {
                        rotateLeft(parent)
                        rotateRight(parent.parent!!.parent!!)
                    } else rotateRight(parent.parent!!)
                    (parent.right as RBNode?)?.color = RED
                }
                else /*parent == parent.parent?.right*/ -> {
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
        elem?.let { adjustAfterDeletion(it) }
        return elem
    }

    private fun adjustAfterDeletion(elem: RBNode) {
        var node = elem
        while (node.color == BLACK && node != root) {
            if (node < node.parent!!) {
                var sibling = node.parent?.right as RBNode
                if (sibling.color == RED) {
                    sibling.color = BLACK
                    node.parent?.color = BLACK // RED
                    rotateLeft(node.parent!!)
                    sibling = node.parent?.right as RBNode
                    sibling.color = RED // TODO("fix")
                }
                if ((sibling.left as RBNode?)?.color == BLACK && (sibling.right as RBNode?)?.color == BLACK) {
                    sibling.color = RED
                    node = node.parent!!
                    continue
                } else if ((sibling.right as RBNode?)?.color == BLACK) {
                    (sibling.left as RBNode?)?.color = BLACK
                    sibling.color = RED
                    rotateRight(sibling)
                    sibling = node.parent?.right as RBNode
                }
                if ((sibling.right as RBNode?)?.isRed() ?: return) {
                    sibling.color = node.parent?.color!!
                    node.parent?.color = BLACK
                    (sibling.right as RBNode?)?.color = BLACK
                    rotateLeft(node.parent!!)
                    node = root as RBNode
                }
            } else {
                var sibling = node.parent?.left as RBNode
                if (sibling.color == RED) {
                    sibling.color = BLACK
                    node.parent?.color = BLACK //RED TODO("FIX")
                    rotateRight(node.parent!!)
                    sibling = node.parent?.left as RBNode
                    sibling.color = RED // TODO("fix")
                }
                if (sibling.left == null) return
                if ((sibling.left as RBNode?)?.color == BLACK && (sibling.right as RBNode?)?.color == BLACK) {
                    sibling.color = RED
                    node = node.parent!!
                    continue
                } else if ((sibling.left as RBNode?)?.color == BLACK) {
                    (sibling.right as RBNode?)?.color = BLACK
                    sibling.color = RED
                    rotateLeft(sibling)
                    sibling = node.parent?.left as RBNode
                }
                if ((sibling.left as RBNode?)?.isRed() ?: return) { // TODO("2")
                    sibling.color = node.parent?.color!!
                    node.parent?.color = BLACK
                    (sibling.left as RBNode?)?.color = BLACK
                    rotateRight(node.parent!!)
                    node = root as RBNode
                }
            }
        }
        node.parent = null
    }

    private fun rotateLeft(node: RBNode) {
        if (node != root) {
            if (node == node.parent?.left) node.parent?.left = node.right
            else node.parent?.right = node.right
            (node.right as RBNode).parent = node.parent
            node.parent = node.right as RBNode?
            if (node.right?.left != null) (node.right?.left as RBNode).parent = node
            node.apply {
                right = node.right?.left
                parent?.left = node
            }
        } else {
            val right = root?.right as RBNode
            root?.right = right.left
            (root?.right as RBNode).parent = root as RBNode
            right.parent = root as RBNode
            right.left = root
            (root as RBNode).parent = right
            right.parent = null
            root = right
        }
    }

    private fun rotateRight(node: RBNode) {
        if (node != root) {
            if (node == node.parent?.left) node.parent?.left = node.left
            else node.parent?.right = node.left
            (node.left as RBNode).parent = node.parent
            node.parent = node.left as RBNode
            if (node.left?.right != null) (node.left?.right as RBNode).parent = node
            node.apply {
                left = node.left?.right
                parent?.right = node
            }
        } else {
            val left = root?.left as RBNode
            root?.left = left.right
            (root as RBNode).parent = left
//            (root as RBNode).color = BLACK
            (left.right as RBNode).parent = root as RBNode
//            (left.right as RBNode).color = RED
            left.right = root
            left.parent = null
            root = left
        }
    }

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun isRed() = color == RED // let compiler inserts != null

        fun isBlack() = color == BLACK // let compiler inserts != null

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
