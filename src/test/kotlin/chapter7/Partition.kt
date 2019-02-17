package chapter7

import org.junit.Test

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava
 *        by Jatzuk on 28.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */
    
class PartitionTest {
    @Test
    fun partitionTest() {
        with(Partition(10)) {
            for (i in 0 until 10) insert((Math.random() * 99).toInt() + 1)
            display()
            val pivot = 50
            print("pivot: $pivot, ")
            val dex = partition(0, size - 1, pivot)
            println("Partition is at index: $dex")
            display()
        }
    }
}
