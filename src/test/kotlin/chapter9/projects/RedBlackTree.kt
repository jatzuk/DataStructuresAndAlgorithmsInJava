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
    fun recolorOnlyTest() {
        with(rbt) {
            insert(10)
            insert(5)
            insert(15)
            insert(20)
//            displayTree()
//            insert(0)
//            insert(6)
//            insert(14)
            insert(25)
//            insert(19)
//            insert(30)
            displayTree()
        }
    }

//    @Test
//    fun rotationsOnlyTest() {
//        with(rbt) {
//
//        }
//    }
}
