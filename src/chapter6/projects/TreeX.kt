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

const val rowSize = 16
val rows = (Math.log(rowSize.toDouble()) / Math.log(2.0) + 1).toInt()
val arr = Array(rows) { "" }

fun makeBranches(left: Int, right: Int, row: Int) {
    if (left - right == 0) return

    val mid = (left + right) / 2
    for (i in left - 1 until right) {
        arr[row] +=
                if (i == mid) "X"
                else "-"
    }

    makeBranches(left, mid, row + 1)
    makeBranches(mid + 1, right, row + 1)
}

fun display() {
    for (i in 0 until rowSize) arr[rows - 1] += "X"
    for (i in arr.indices) println(arr[i])
}

fun main(args: Array<String>) {
    makeBranches(0, rowSize - 1, 0)
    display()
}