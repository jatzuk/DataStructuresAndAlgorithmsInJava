package chapter6.projects

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

fun power(x: Int, y: Int): Int {
    return if (y == 1) x
    else power(x * x, y / 2) * if (y % 2 == 0) 1 else x
}
