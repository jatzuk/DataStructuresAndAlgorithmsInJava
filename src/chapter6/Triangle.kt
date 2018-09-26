package chapter6

/**
 * Created by Jatzuk on 23.09.2018
 */

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

fun main(args: Array<String>) {
    println(triangleRecursively(4))
    println(factorial(5))
}