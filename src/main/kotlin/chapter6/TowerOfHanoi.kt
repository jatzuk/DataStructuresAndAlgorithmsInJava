package chapter6

/**
 * Created by Jatzuk on 23.09.2018
 */

fun solveProblem(topN: Int, from: Char, inter: Char, to: Char) {
    if (topN == 1) println("Disk 1 from $from to $to")
    else {
        solveProblem(topN - 1, from, to, inter)
        println("Disk $topN from $from to $to")
        solveProblem(topN - 1, inter, from, to)
    }
}

fun main(args: Array<String>) {
    solveProblem(3, 'A', 'B', 'C')
}