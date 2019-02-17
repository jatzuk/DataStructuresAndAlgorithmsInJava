package chapter6

/**
 * Created by Jatzuk on 23.09.2018
 */

private val arr = arrayOf(1, 2, 3, 4)

fun binarySearchRecursively(searchKey: Int, lowerBound: Int, upperBound: Int): Int {
    val cur = (lowerBound + upperBound) / 2
    return if (arr[cur] == searchKey) cur
    else if (lowerBound > upperBound) -1
    else {
        if (arr[cur] < searchKey) binarySearchRecursively(searchKey, cur + 1 , upperBound)
        else binarySearchRecursively(searchKey, lowerBound, cur - 1)
    }
}

fun main(args: Array<String>) {
    println(binarySearchRecursively(2, 0, arr.size - 1))
}