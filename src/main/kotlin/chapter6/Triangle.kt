package chapter6

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 23.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

@Suppress("NAME_SHADOWING")
fun triangleIteratively(n: Int): Int {
    var n = n
    var total = 0
    while (n > 0) {
        total += n--
    }
    return total
}

fun triangleRecursively(n: Int): Int {
    return if (n == 1) 1
    else (n + triangleRecursively(n - 1))
}

fun factorial(n: Int) : Int {
    return if (n == 0) 1
    else (n * factorial(n - 1))
}
