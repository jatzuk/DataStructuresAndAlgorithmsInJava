package chapter6.projects

/**
 ** Created with passion and love
 **    for project DataStructuresAndAlgorithmsInJava
 **        by Jatzuk on 25-Oct-18
 **                                            *_____*
 **                                           *_*****_*
 **                                          *_(O)_(O)_*
 **                                         **____V____**
 **                                         **_________**
 **                                         **_________**
 **                                          *_________*
 **                                           ***___***
 */

const val st = 20
private val array = arrayOf(11, 8, 7, 6, 5)
private val result = ArrayList<Int>()

fun knapsackProblem(index: Int, target: Int) {
    val cur = array[index]
    val nt = target - cur
    if (cur == target) {
        println(result)
        return
    } else {
        if (nt < 0) {
            result.removeAt(result.size - 1)
            return
        } else {
            for (j in index + 1 until array.size) {
                result.add(array[j])
                knapsackProblem(j, nt)
            }
        }
    }
}

fun main(args: Array<String>) {
    for (i in 0 until array.size) {
        result.add(array[i])
        knapsackProblem(i, st)
        result.clear()
    }
}