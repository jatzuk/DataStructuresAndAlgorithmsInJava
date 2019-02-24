package chapter8.projects.huffmanTree

import chapter8.DefinitelyNotABinarySearchTree
import chapter8.projects.huffmanTree.HuffmanEncoder.Companion.NEWLINE_SYMBOL_CODE
import chapter8.projects.huffmanTree.HuffmanEncoder.Companion.PATH
import chapter8.projects.huffmanTree.HuffmanEncoder.Companion.SPACE_SYMBOL_CODE
import java.io.File
import java.io.IOException

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HuffmanDecoder(path: String) : DefinitelyNotABinarySearchTree<Char>() {
    private val letters = Array(28) { "" }
    lateinit var message: String

    init {
        readEncoded(path)?.let { encode(it) }
    }

    @Throws(IOException::class)
    private fun readEncoded(path: String) = try {
        File(path).bufferedReader().readLines()
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }

    @Throws(IllegalArgumentException::class)
    private fun encode(lines: List<String>) {
        if (lines.isEmpty()) {
            throw IllegalArgumentException("file ${PATH.substringAfterLast("\\")} is empty")
        }
        getLetters(lines[0])
        val result = StringBuilder()
        val sb = StringBuilder()
        for (letter in lines[1]) {
            sb.append(letter)
            val index = isLetter(sb.toString())
            if (index > -1) {
                val char = when ('a' + index) {
                    '{' -> ' '
                    '|' -> '\n'
                    else -> 'a' + index
                }
                result.append(char)
                sb.clear()
            }
        }
        message = result.toString()
    }

    private fun getLetters(table: String) {
        var i = 0
        while (i < table.length) {
            val char = table[i]
            if (char in 'a'..'z' || char == SPACE_SYMBOL_CODE || char == NEWLINE_SYMBOL_CODE) {
                var j = ++i
                while (table[j] != ' ') j++
                val code = table.substring(i, j)
                val index = adoptChar(char)
                letters[index] = code
                i = ++j
            }
        }
    }

    private fun isLetter(string: String): Int {
        for ((i, letter) in letters.withIndex()) if (letter == string) return i
        return -1
    }

    private fun adoptChar(char: Char) = when (char) {
        SPACE_SYMBOL_CODE -> 26
        NEWLINE_SYMBOL_CODE -> 27
        else -> char - 'a'
    }
}
