package chapter7.projects

import chapter7.QuickSort2

/**
 * Created by Jatzuk on 14.11.2018
 */

class QuickSortCounting(size: Int) : QuickSort2(size) {
    fun printStatistics() {
        println("comparisons: $comparisons")
        println("copies: $copies")
    }
}
