package chapter6

/**
 * Created by Jatzuk on 23.09.2018
 */

private val arr = "kotlin".toCharArray()
private val length = arr.size
private var count = 0

fun anagram(size: Int) {
    if (size == 1) return
    for (i in 0 until size) {
        anagram(size - 1)
        if (size == 2) displayWord()
        rotate(size)
    }
}

fun rotate(size: Int) {
    val pos = length - size
    val ch = arr[pos]
    for (i in pos + 1 until length) arr[i - 1] = arr[i]
    arr[length - 1] = ch
}

fun displayWord() {
    if (count < 99) print(" ")
    if (count < 9) print(" ")
    print("${++count}.")
    for (i in 0 until length) print(arr[i])
    print(" ")
    if (count % 6 == 0) println()
}

fun main(args: Array<String>) {
    anagram(length)
}