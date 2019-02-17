package chapter6

import chapter6.projects.display
import chapter6.projects.makeBranches
import chapter6.projects.rowSize
import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 25.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class TreeXTest {
    @Test
    fun treeXTest() {
        makeBranches(0, rowSize - 1, 0)
        display()
    }
}
