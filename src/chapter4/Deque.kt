package chapter4

/**
 * Created by Jatzuk on 15.09.2018
 */

class Deque(maxSize: Int) : Queue(maxSize) {
    fun insertRight(n: Int) {
        insert(n)
    }

    fun removeRight(): Int {
        size--
        return array[rear--]
    }

    fun insertLeft(n: Int) {
        if (++front == rear) front++
        array[front] = n
        size++
    }

    fun removeLeft(): Int {
        val tmp = remove()
        if (front >= size - 1) front = 0
        return tmp
    }
}

fun main(args: Array<String>) {
    val deque = Deque(5)
    deque.insertRight(4)
    deque.insertRight(7)
    deque.removeRight()
    deque.insertRight(7)
    deque.insertLeft(3)
    deque.removeLeft()

    deque.display()
}