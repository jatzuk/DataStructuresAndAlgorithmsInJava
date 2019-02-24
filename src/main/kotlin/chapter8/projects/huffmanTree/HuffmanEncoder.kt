package chapter8.projects.huffmanTree

import chapter8.BinaryTree
import java.io.File
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

class HuffmanEncoder(source: String) : BinaryTree<Char>() {
    private val table = Array(28) { "" }
    private val message: String

    init {
        val eligible = Array(28) { 'a' + it }.apply {
            set(26, ' ')
            set(27, '\n')
        }
        message = source.filterSource { it in eligible }
        val map = HashMap<Char, Int>()
        for (ch in message) {
            val char = when (ch) {
                ' ' -> SPACE_SYMBOL_CODE
                '\n' -> NEWLINE_SYMBOL_CODE
                else -> ch
            }
            map[char] = if (map.containsKey(char)) map[char]!!.inc() else 1
        }

        with(PriorityQueue<Node?>()) {
            map.forEach { k, v -> offer(Node(k, v)) }
            while (size > 1) {
                val ln = poll()!!
                val rn = poll()!!
                offer(Node(NODE_SYMBOL_CODE, ln.frequency + rn.frequency).apply {
                    left = ln
                    right = rn
                })
            }
            root = poll()
        }

        createTable(root!!)
        encode()
    }

    private fun createTable(node: Node, code: StringBuilder = StringBuilder()) {
        if (node.data != NODE_SYMBOL_CODE) {
            table[adoptChar(node.data)] = code.toString()
            return
        } else {
            with(code) {
                append("0")
                createTable(node.left!!, this)
                deleteCharAt(length - 1)
                append("1")
                createTable(node.right!!, this)
                deleteCharAt(length - 1)
            }
        }
    }

    private fun encode() {
        File(PATH).bufferedWriter().use { out ->
            table.forEachIndexed { i, s ->
                val code = when (i) {
                    26 -> SPACE_SYMBOL_CODE
                    27 -> NEWLINE_SYMBOL_CODE
                    else -> 'a' + i
                }
                if (s.isNotEmpty()) out.write("$code$s ")
            }
            out.write("\n")
            message.forEach { out.write(table[adoptChar(it)]) }
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

    private fun String.filterSource(predicate: (Char) -> Boolean): String {
        val sb = StringBuilder()
        for (i in 0 until length) with(get(i)) { if (predicate(this)) sb.append(this) }
        return sb.toString()
    }

    private fun adoptChar(char: Char) = when (char) {
        SPACE_SYMBOL_CODE, ' ' -> 26
        NEWLINE_SYMBOL_CODE, '\n' -> 27
        else -> char - 'a'
    }

    companion object {
        const val PATH = "src\\test\\resources\\chapter8\\huffmanTree\\encoded.txt"
        const val NODE_SYMBOL_CODE = '*'
        const val SPACE_SYMBOL_CODE = '~'
        const val NEWLINE_SYMBOL_CODE = '>'
    }
}
