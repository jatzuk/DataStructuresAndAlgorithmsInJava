package chapter8

import chapter9.AbstractNode
import chapter9.projects.RedBlackTree.Color.BLACK
import chapter9.projects.RedBlackTree.Color.RED
import chapter9.projects.RedBlackTree.RBNode
import java.util.*

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class BinaryTree<T> {
    var root: Node? = null

    open fun find(key: T): Node? {
        var current = root
        while (current?.data != key) {
            if (current == null) return null
            current = if (key < current.data) current.left else current.right
        }
        return current
    }

    open fun insert(value: T) {
        val node = Node(value)
        if (root == null) root = node
        else {
            var current = root
            var parent: Node
            while (true) {
                parent = current!!
                if (value < current.data) {
                    current = current.left
                    if (current == null) {
                        parent.left = node
                        return
                    }
                } else {
                    current = current.right
                    if (current == null) {
                        parent.right = node
                        return
                    }
                }
            }
        }
    }

    fun clear() {
        root = null
    }

    open fun delete(key: T): Node? {
        if (root == null) return null
        var current = root
        var parent = current!!
        var isLeft = false
        while (current!!.data != key) {
            parent = current
            if (key < current.data) {
                current = current.left
                isLeft = true
            } else {
                current = current.right
                isLeft = false
            }
            if (current == null) return null
        }
        if (current.left == null && current.right == null) {
            when {
                current == root -> root = null
                isLeft -> parent.left = null
                else -> parent.right = null
            }
        } else if (current.right == null) {
            when {
                current == root -> root = current.left
                isLeft -> {
                    parent.left = current.left
                    // RBT fix
                    (current.left as RBNode).color = BLACK
                    (current.left as RBNode).parent = (current as RBNode).parent
                    (current as RBNode).color = RED
                }
                else -> parent.right = current.left
            }
        } else if (current.left == null) {
            when {
                current == root -> root = current.right
                isLeft -> parent.left = current.right
                else -> {
                    parent.right = current.right
                    // RBT fix
                    (current.right as RBNode).color = BLACK
                    (current.right as RBNode).parent = (current as RBNode).parent
                    (current as RBNode).color = RED
                }
            }
        } else {
            val successor = getSuccessor(current)
            when {
                current == root -> root = successor
                isLeft -> parent.left = successor
                else -> parent.right = successor
            }
            // RBT fix
            (successor as RBNode).parent = parent as RBNode
        }
        return current
    }

    private fun getSuccessor(delNode: Node): Node {
        var parent = delNode
        var successor = delNode
        var current = delNode.left
        while (current != null) {
            parent = successor
            successor = current
            current = current.right
        }
        (successor as RBNode).color = BLACK
        return with(successor as Node) {
            right = delNode.right
            (right as RBNode).parent = successor
            parent.right = left
            if (this != delNode.left) left = delNode.left
            this
        }
    }

    fun traverse(traverseType: Int) {
        when (traverseType) {
            1 -> {
                println("\nPreorder traversal:")
                preOrder(root)
            }
            2 -> {
                println("\nInorder traversal:")
                inOrder(root)
            }
            3 -> {
                println("\nPostorder traversal")
                postOrder(root)
            }
        }
    }

    private fun preOrder(node: Node?) {
        node?.let {
            node.display()
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    open fun inOrder(node: Node?) {
        node?.let {
            inOrder(node.left)
            node.display()
            inOrder(node.right)
        }
    }

    private fun postOrder(node: Node?) {
        node?.let {
            postOrder(node.left)
            postOrder(node.right)
            node.display()
        }
    }

    fun displayTree() {
        val stack: Deque<Node?> = LinkedList()
        stack.push(root)
        var blanks = 32
        var isRowEmpty = false
        repeat(30) { print("."); if (it == 29) println() }
        while (!isRowEmpty) {
            val localStack: Deque<Node?> = LinkedList()
            isRowEmpty = true
            repeat(blanks) { print(" ") }
            while (stack.isNotEmpty()) {
                val tmp = stack.pop()
                if (tmp != null) {
                    tmp.display()
                    localStack.push(tmp.left)
                    localStack.push(tmp.right)
                    if (tmp.left != null || tmp.right != null) isRowEmpty = false
                } else {
                    print("--")
                    localStack.push(null)
                    localStack.push(null)
                }
                repeat(blanks * 2 - 2) { print(" ") }
            }
            println()
            blanks /= 2
            while (localStack.isNotEmpty()) stack.push(localStack.pop())
        }
        repeat(30) { print("."); if (it == 29) println() }
    }

    operator fun <T> T.compareTo(other: T) = when (this) {
        is Int -> this - other
        is Char -> this.toInt() - (other as Char).toInt()
        else -> throw IllegalArgumentException()
    }

    private operator fun <T> Int.minus(value: T) = this - value as Int
    private operator fun <T> Char.minus(value: T) = this - value as Int

    open inner class Node(data: T, var frequency: Int = -1) : AbstractNode<T, Node>(data) {
        override var left: Node? = null
        override var right: Node? = null

        override fun display() {
            print("$data")
//            print("($frequency)$data")
        }
    }
}
