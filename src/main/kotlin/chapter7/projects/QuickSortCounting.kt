package chapter7.projects

import chapter7.QuickSort2

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 14.11.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class QuickSortCounting(size: Int) : QuickSort2(size) {
    fun printStatistics() {
        println("comparisons: $comparisons")
        println("copies: $copies")
    }
}
