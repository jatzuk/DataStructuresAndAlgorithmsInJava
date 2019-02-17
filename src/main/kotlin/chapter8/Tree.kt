package chapter8

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

open class Tree<T> {
    var root: Node<T>? = null

    open fun find(key: T): Node<T>? {
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
            var parent: Node<T>
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

    open fun delete(key: T): Boolean {
        if (root == null) return false
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
            if (current == null) return false
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
                isLeft -> parent.left = current.left
                else -> parent.right = current.left
            }
        } else if (current.left == null) {
            when {
                current == root -> root = current.right
                isLeft -> parent.left = current.right
                else -> parent.right = current.right
            }
        } else {
            val successor = getSuccessor(current)
            when {
                current == root -> root = successor
                isLeft -> parent.left = successor
                else -> parent.right = successor
            }
        }
        return true
    }

    private fun getSuccessor(delNode: Node<T>): Node<T> {
        var parent = delNode
        var successor = delNode
        var current = delNode.right
        while (current != null) {
            parent = successor
            successor = current
            current = current.left
        }
        if (successor != delNode.right) {
            parent.left = successor.right
            successor.right = delNode.right
        }
        return successor
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

    private fun preOrder(node: Node<T>?) {
        node?.let {
            node.display()
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    private fun inOrder(node: Node<T>?) {
        node?.let {
            inOrder(node.left)
            node.display()
            inOrder(node.right)
        }
    }

    private fun postOrder(node: Node<T>?) {
        node?.let {
            postOrder(node.left)
            postOrder(node.right)
            node.display()
        }
    }

    fun displayTree() {
        val stack: Deque<Node<T>?> = LinkedList()
        stack.push(root)
        var blanks = 32
        var isRowEmpty = false
        repeat(30) { print("."); if (it == 29) println() }
        while (!isRowEmpty) {
            val localStack: Deque<Node<T>?> = LinkedList()
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
}

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null

    fun display() {
        print(data)
    }

//    TODO()
    operator fun compareTo(element: T): Int {
        return data as Int - element as Int
    }
}

