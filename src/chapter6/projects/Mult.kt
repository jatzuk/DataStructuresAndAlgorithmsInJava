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

fun mult(x: Int, y: Int): Int {
    return if (y == 1) x
    else x + mult(x, y - 1)
}
