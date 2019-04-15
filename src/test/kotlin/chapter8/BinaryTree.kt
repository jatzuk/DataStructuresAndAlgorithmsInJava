package chapter8

import org.junit.Assert.assertEquals
import org.junit.Test

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

class BinaryTreeTest {
    @Test
    fun intTreeTest() {
        with(BinaryTree<Int>()) {
            insert(50)
            insert(25)
            insert(75)
            insert(12)
            insert(37)
            insert(43)
            insert(30)
            insert(33)
            insert(87)
            insert(93)
            insert(97)

            displayTree()
            insert(22)
            displayTree()
            assertEquals(33, find(33)?.data)
            assertEquals(true, delete(87))
            displayTree()
        }
    }

    @Test
    fun charTreeTest() {
        with(BinaryTree<Char>()) {
            insert('f')
            insert('c')
            insert('k')
            insert('a')
            insert('b')
            insert('z')
            displayTree()
            insert('o')
            displayTree()
            assertEquals('k', find('k')?.data)
            assertEquals(true, delete('c'))
            displayTree()
        }
    }

    @Test
    fun removalTest() {
        with(BinaryTree<Int>()) {
            insert(10)
            insert(5)
            insert(15)
            insert(20)
            insert(19)
            insert(21)
            displayTree()
            delete(20)
            displayTree()
            insert(18)
            insert(17)
            insert(14)
            insert(11)
            insert(13)
            displayTree()
            delete(15)
            displayTree()

//            insert(20)
//            insert(15)
//            insert(25)
//            insert(11)
//            insert(12)
//            insert(14)
//            displayTree()
//            delete(20)
//            displayTree()
        }
    }

    @Test
    fun rootDeletionTest() {
        with(BinaryTree<Int>()) {
            insert(10)
            insert(5)
            insert(15)
            insert(12)
            insert(19)
            insert(11)
            insert(13)
            insert(21)
            displayTree()
            delete(10)
            displayTree()
        }
    }
}
