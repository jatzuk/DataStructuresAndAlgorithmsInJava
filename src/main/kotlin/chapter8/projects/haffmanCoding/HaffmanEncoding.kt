package chapter8.projects.haffmanCoding

import chapter8.BinaryTree
import java.util.*
import kotlin.collections.HashMap

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava
 *        by Jatzuk on 23.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HaffmanEncoding(source: String) : BinaryTree<Char>() {
    private val map = HashMap<Char, Int>()

    init {
        for (ch in "$source\n") {
            val char = when (ch) {
                ' ' -> '~'
                '\n' -> '>'
                else -> ch
            }
            if (map.containsKey(char)) map[char] = map[char]!!.inc()
            else map[char] = 1
        }
    }

    fun buildTree() {
        with(PriorityQueue<Node?>()) {
            map.forEach { k, v -> offer(Node(k, v)) }
            while (size > 1) {
                val ln = poll()
                val rn = poll()
                offer(Node('*', ln!!.frequency + rn!!.frequency).apply {
                    left = ln
                    right = rn
                })
                forEach { println("${it!!.data} left: ${it.left?.data} right: ${it.right?.data}") }
                break
            }
            root = poll()
        }
    }

    override fun find(key: Char): Node? {
        throw NotImplementedError("operation is not supported")
    }

    override fun delete(key: Char): Boolean {
        throw NotImplementedError("operation is not supported")
    }

    override fun insert(value: Char) {
        throw NotImplementedError("operation is not supported")
    }
}
