package chapter10.projects

import chapter10.Tree234
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 01.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Tree234UtilsTest {
    private val tree = Tree234()

    @Before
    fun setUp() {
        with(tree) {
            insert(10)
            insert(20)
            insert(30)
            insert(40)
            insert(50)
            insert(60)
            insert(70)
            insert(80)
            insert(0)
            displayTree()
            println()
        }
    }

    @Test
    fun minTest() {
        assertEquals(0, tree.min())
    }

    @Test
    fun orderTraverseTest() {
        tree.orderTraverse()
    }

    @Test
    fun sortTest() {
        val target = generateSequence(80) { it - 10 }.take(9).toList().toTypedArray()
        tree.sort(target)
        println(Arrays.toString(target))
    }
}
