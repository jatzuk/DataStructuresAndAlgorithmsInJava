package chapter9.projects

import org.junit.Test

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

class RedBlackTreeTest {
    private val rbt = RedBlackTree()

    @Test
    fun recolorTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(20)
            displayTree()
        }
    }

    @Test
    fun leftRotationsTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(20)
            insert(25)
            insert(30)
            insert(35)
            displayTree()
            insert(40)
            insert(0)
            displayTree()
        }
    }

    @Test
    fun rightRotationsTest() {
        with(rbt) {
            insert(50)
            insert(40)
            insert(60)
            insert(35)
            insert(45)
            insert(30)
            insert(25)
            insert(20)
            displayTree()
        }
    }

    @Test
    fun mergeTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(19)
            insert(24)
            insert(31)
            insert(36)
            insert(41)
            insert(0)
            displayTree()

            insert(50)
            insert(40)
            insert(60)
            insert(35)
            insert(45)
            insert(30)
            insert(25)
            insert(20)
            displayTree()
        }
    }

    @Test
    fun twoCaseRightRotationsTest() {
        with(rbt) {
            insert(50)
            insert(60)
            insert(45)
            insert(46)
            insert(44)
            insert(43)
            displayTree()
            delete(60) // rotate root
            displayTree()
            insert(42) // fix up
            displayTree()
        }
    }

    @Test
    fun twoCaseLeftRotationsTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(13)
            insert(20)
            insert(25)
            displayTree()
            delete(5) // rotate root
            displayTree()
            insert(26) // fix up
            displayTree()
        }
    }

    @Test
    fun chaosCasesTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(13)
            insert(20)
            insert(25)
//            displayTree()
            delete(5)
//            displayTree()
            insert(26)
//            displayTree()
            insert(14)
            insert(18)
            insert(19)
            insert(30)
//            displayTree()
            delete(20)
//            displayTree()
            delete(19)
//            displayTree()
            insert(4)
//            displayTree()
            insert(3)
            insert(2)
            insert(1)
            insert(9)
            insert(11)
            displayTree()
            delete(10)
            displayTree()
        }
    }
}
