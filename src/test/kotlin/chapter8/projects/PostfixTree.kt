package chapter8.projects

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import java.util.*

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 22.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class PostfixTreeTest {
    @Ignore
    fun postfixExpression() {
        val expression = "45678*+-/"
        val stack = ArrayDeque<Int>()
        var res = 0
        repeat(expression.length) {
            val ch = expression[it]
            if (ch.isDigit()) stack.push(Character.getNumericValue(ch))
            else {
                val a = stack.pop()
                val b = stack.pop()
                res = when (ch) {
                    '+' -> a + b
                    '-' -> a - b
                    '*' -> a * b
                    '/' -> a / b
                    else -> throw IllegalArgumentException()
                }
                stack.push(res)
            }
        }
        assertEquals(14, res)
    }

    @Test
    fun postfixTreeTest() {
        PostfixTree((charArrayOf('A', 'B', 'C', '+', '*'))).displayTree()
    }

    @Test
    fun postfixTreeAFTest() {
        PostfixTree(charArrayOf(*('A'..'F').toList().toCharArray(), '+', '-', '*', '/'))
            .displayTree()
    }

    @Test
    fun traversePreOrderTest() {
        PostfixTree((charArrayOf('A', 'B', 'C', '+', '*'))).traverse(1)
    }

    @Test
    fun traverseInOrderTest() {
        PostfixTree((charArrayOf('A', 'B', 'C', '+', '*'))).traverse(2)
    }

    @Test
    fun traversePostOrderTest() {
        PostfixTree((charArrayOf('A', 'B', 'C', '+', '*'))).traverse(3)
    }

}
