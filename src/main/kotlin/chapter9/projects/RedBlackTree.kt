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
        if (node != root && node?.parent!!.isRed()) {
            val parent = node.parent!!
            val sibling = parent.getSibling()
            when {
                sibling != null && sibling.isRed() -> {
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
                }
                parent == parent.parent?.right -> {
                    if (node == parent.left) {
                        rotateRight(parent)
                        rotateLeft(parent.parent!!.parent!!)
                    } else rotateLeft(parent.parent!!)
                }
            }
        }

        with(root as RBNode) { if (isRed()) color = BLACK }
    }

    override fun delete(key: Int): Node? {
        val elem = super.delete(key) as RBNode?
        elem?.let { adjustAfterDeletion(it) }
        return elem
    }

    private fun adjustAfterDeletion(elem: RBNode) {
        var node = elem
        while (!node.isRed() && node != root) {
            val isLeft = node < node.parent!!
            if (isLeft) {
                var sibling = node.parent?.right as RBNode
                if (sibling.isRed()) {
                    sibling.color = BLACK
                    node.parent?.color = RED
                    rotateLeft(node.parent!!)
                    sibling = node.parent?.right as RBNode
                }
                if ((sibling.left as RBNode?)?.color == BLACK && (sibling.right as RBNode?)?.color == BLACK) {
                    sibling.color = RED
                    node = node.parent!!
                } else {
                    if ((sibling.right as RBNode?)?.color == BLACK) {
                        (sibling.left as RBNode?)?.color = BLACK
                        sibling.color = RED
                        rotateRight(sibling)
                        sibling = node.parent?.right as RBNode
                    }
                    sibling.color = node.parent?.color!!
                    node.parent?.color = BLACK
                    (sibling.right as RBNode?)?.color = BLACK
                    rotateLeft(node.parent!!)
                    node = root as RBNode
                }
            } else {
                var sibling = node.parent?.left as RBNode
                if (sibling.isRed()) {
                    sibling.color = BLACK
                    node.parent?.color = RED
                    rotateRight(node.parent!!)
                    sibling = node.parent?.left as RBNode
                }
                if ((sibling.left as RBNode?)?.color == BLACK && (sibling.right as RBNode?)?.color == BLACK) {
                    sibling.color = RED
                    node = node.parent!!
                } else {
                    if ((sibling.left as RBNode?)?.color == BLACK) {
                        (sibling.right as RBNode?)?.color = BLACK
                        sibling.color = RED
                        rotateLeft(sibling)
                        sibling = node.parent?.left as RBNode
                    }
                    sibling.color = node.parent?.color!!
                    node.parent?.color = BLACK
                    (sibling.left as RBNode?)?.color = BLACK
                    rotateRight(node.parent!!)
                    node = root as RBNode
                }
            }
        }
    }

    private fun rotateLeft(node: RBNode) {
        with(node) {
            if (node != root) {
//                val subtree = (right as RBNode).apply {
//                    color = BLACK
//                    parent = node.parent
//                    left = node
//                }
//                color = RED
//                right = null
//                linkToParent(node, subtree)
//                parent = subtree

            } else {
                val newRoot = right as RBNode
                newRoot.parent = null
                val sibling = newRoot.left as RBNode
                val subNode = (root as RBNode).apply {
                    color = RED
                    right = sibling
                    parent = newRoot
                }
                sibling.parent = subNode
                root = newRoot
                newRoot.left = subNode
            }
        }
    }

    private fun rotateRight(node: RBNode) {
        with(node) {
            if (this != root) {
                right = RBNode(parent!!.data).apply { parent = node }
                color = BLACK
                parent = parent?.parent
                parent?.left = node
            } else {
                val newRoot = node.left as RBNode
                newRoot.parent = null
                val sibling = newRoot.right as RBNode
                val subNode = (root as RBNode).apply {
                    color = RED
                    left = sibling
                    parent = newRoot
                }
                sibling.parent = subNode
                root = newRoot
                newRoot.right = subNode
            }
        }
    }

    private fun linkToParent(node: RBNode, child: RBNode) {
        with(node) {
            if (this == parent!!.right) parent!!.right = child
            else parent!!.left = child
        }
    }

    inner class RBNode(data: Int, var color: Color = RED) : Node(data) {
        var parent: RBNode? = null

        fun isRed() = color == RED

        private fun isBlack() = color == BLACK

        fun getSibling() = when {
            this == root -> null
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
