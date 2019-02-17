package chapter2

import org.junit.Test
import java.util.*

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 06.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HighArrayTest {
    @Test
    fun insertionSortStupid() {
        val highArray = HighArray(10)
        for (i in 0 until 10) highArray.insert((Math.random() * 10).toInt() + 1)
        highArray.display()
        val sortedArray = IntArray(highArray.size) { 0 }
        for (i in 0 until sortedArray.size) sortedArray[i] = highArray.removeMax()
        println(Arrays.toString(sortedArray))
    }
}
