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
            insert(40)
            insert(0)
            displayTree()
        }
    }

    @Test
    fun rightRotationsTest() {
        with(rbt) {
            insert(50)
            insert(45)
            insert(65)
            insert(40)
//            displayTree()
            insert(35)
//            displayTree()
            insert(30)
//            displayTree()
            insert(15)
            displayTree()
            insert(10)
            displayTree()
//            insert(20)
//            insert(15)
//            displayTree()
//            displayTree()
        }
    }
}
