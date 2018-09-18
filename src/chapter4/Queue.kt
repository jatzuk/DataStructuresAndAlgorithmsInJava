package chapter4

/**
 * Created by Jatzuk on 15.09.2018
 */

open class Queue(private val maxSize: Int) {
    protected val array = IntArray(maxSize) { 0 }
    var front = 0
    var rear = -1
    protected var size = 0

    open fun insert(n: Int) {
        if (isFull()) {
            println("Queue is full")
            return
        }
        if (rear == maxSize - 1) rear = -1
        array[++rear] = n
        size++
    }

    open fun remove(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val tmp = array[front++]
        if (front == maxSize) front = 0
        size--
        return tmp
    }

    open fun peekFront() = array[front]

    fun isEmpty() = size == 0

    fun isFull() = size == maxSize

    fun size() = size

    open fun display() {
        if (isEmpty()) {
            println("Queue is empty")
            return
        }
        var head = front
        for (i in 0 until size) {
            if (head == maxSize || head == size) head = 0
            val elem = array[head++]
            print("$elem ")
        }
        println()
    }
}
