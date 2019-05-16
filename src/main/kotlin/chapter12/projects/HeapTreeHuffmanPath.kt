package chapter12.projects

import java.util.*

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 16.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 * ex 5
 */

class HeapTreeHuffmanPath {
    private var root: Node? = null
    var size = 0
        private set

    fun insert(key: Int) {
        val node = Node(key)
        if (size == 0) root = node
        else {
            var current = root
            var n = size + 1
            var i = 0
            val path = Array(n) { 0 }

            while (n > 0) {
                path[i] = n % 2
                n /= 2
                i++
            }
            for (j in i - 2 downTo 1) {
                current = if (path[j] == 1) current?.right else current?.left
            }

            if (current?.left == null) current?.left = node.apply { isLeft = true }
            else current.right = node.apply { isLeft = false }
            node.parent = current
            trickleUp(node)
        }
        size++
    }

    private fun trickleUp(node: Node) {
        val bottom = node.data
        var current = node
        while (current.parent != null && current.parent!!.data < bottom) {
            current.data = current.parent!!.data
            current = current.parent!!
        }
        current.data = bottom
    }

    fun remove(): Node? {
        val deletion = root
        return when (size) {
            0 -> deletion
            1 -> {
                root = null
                size--
                deletion
            }
            else -> {
                var current = root
                var n = size
                var i = 0
                val path = Array(n) { 0 }

                while (i > 0) {
                    path[i++] = n % 2
                    n /= 2
                }
                for (j in i - 2 downTo 0) {
                    current = if (path[j] == 1) current?.right else current?.left
                }

                root?.data = current?.data!!

                if (current.isLeft) current.parent?.left = null
                else current.parent?.right = null
                trickleDown(root!!)
                size--
                deletion
            }
        }
    }

    private fun trickleDown(node: Node) {
        var current = node
        val top = node.data
        while (current.left != null || current.right != null) {
            val larger =
                if (current.right != null && current.left!!.data < current.right!!.data) current.right
                else current.left
            if (top >= larger!!.data) break
            current.data = larger.data
            current = larger
        }
        current.data = top
    }

    fun change(index: Int, value: Int): Boolean {
        if (index < 0 || index > size) return false
        var current = root
        var n = size + 1
        var i = 0
        val path = Array(n) { 0 }

        while (n > 0) {
            path[i++] = n % 2
            n /= 2
        }
        for (j in i - 2 downTo 0) {
            current = if (path[j] == 1) current?.right else current?.left
        }

        val old = current!!.data
        current.data = value
        if (old < value) trickleUp(current)
        else trickleDown(current)
        return true
    }

    fun displayHeapTree() {
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
                    print("${tmp.data} ")
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

    fun isEmpty() = size == 0

    class Node(var data: Int) {
        var parent: Node? = null
        var left: Node? = null
        var right: Node? = null
        var isLeft = true
    }
}
