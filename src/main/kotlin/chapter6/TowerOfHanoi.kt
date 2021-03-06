package chapter6

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 23.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

fun solveProblem(topN: Int, from: Char, inter: Char, to: Char) {
    if (topN == 1) println("Disk 1 from $from to $to")
    else {
        solveProblem(topN - 1, from, to, inter)
        println("Disk $topN from $from to $to")
        solveProblem(topN - 1, inter, from, to)
    }
}
