package chapter10

import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 30.04.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Tree234Test {
    private val tree = Tree234()

    @Test
    fun performance() {
        with(tree) {
            insert(50)
            insert(40)
            insert(60)
            insert(30)
            insert(70)
            insert(10)
            insert(20)
            insert(12)
            displayTree()
        }
    }
}
