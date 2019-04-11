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
    fun simpleDeletionTest() {
        with(rbt) {
            insert(10)
            insert(15)
            insert(5)
            insert(20)
            displayTree()

            delete(15)
            displayTree()
        }
    }
}
