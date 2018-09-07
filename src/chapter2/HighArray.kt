package chapter2

import java.util.*

/**
 * Created by Jatzuk on 06.09.2018
 */

open class HighArray(max: Int) {
    protected val array = IntArray(max) { 0 }
    protected var size = 0

    //    changed return type to Int for ex 2.3
    open fun find(key: Int): Int {
        for (i in 0 until size) if (array[i] == key) return i
        return -1
    }

    open fun insert(value: Int) {
        array[size++] = value
    }

    open fun delete(value: Int): Boolean {
        val k = find(value)
        return if (k == -1) false
        else {
            for (i in k until size - 1) array[i] = array[i + 1]
            size--
            true
        }
    }

    fun display() {
        for (i in 0 until size) print("${array[i]} ")
        println()
    }

    fun getMax(): Int {
        if (size == 0) return -1
        var max = Integer.MIN_VALUE
        for (i in 0 until size) if (array[i] > max) max = array[i]
        return max
    }

    fun removeMax(): Int {
        val max = getMax()
        if (max != -1) delete(max)
        return max
    }

    fun clear() {
        while (size-- > 1) array[size] = 0
    }
}

/*
fun main(args: Array<String>) {
    val array = HighArray(10)
    for (i in 0 until 10) array.insert(i)
    array.display()

    val result = array.find(0b100)
    println(result)

    println(array.delete(2))
    array.display()
    println(array.delete(5))
    println(array.delete(0))
    array.display()
    println(array.delete(4))
    array.display()

    array.insert(100)
    println(array.getMax())
    println(array.removeMax())
    array.display()

//    insertion sort stupid
    array.clear()
    for (i in 0 until 10) array.insert((Math.random() * 10).toInt() + 1)
    array.display()
    val sortedArray = IntArray(array.size) { 0 }
    for (i in 0 until array.size) sortedArray[i] = array.removeMax()
    println(Arrays.toString(sortedArray))
}*/
