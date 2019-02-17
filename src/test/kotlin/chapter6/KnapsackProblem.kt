package chapter6

import chapter6.projects.KnapsackProblem
import org.junit.Test

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class KnapsackProblemTest {
    @Test
    fun knapsackProblemTest() {
        val st = 20
        with(KnapsackProblem()) {
            for (i in 0 until array.size) {
                result.add(array[i])
                knapsackProblem(i, st)
                result.clear()
            }
        }
    }
}
