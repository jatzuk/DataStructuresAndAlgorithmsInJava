package chapter4

/**
 * Created by Jatzuk on 15.09.2018
 */

open class Deque(maxSize: Int) : Queue(maxSize) {
    open fun insertRight(n: Int) {
        insert(n)
    }

    open fun removeRight(): Int {
        val tmp = array[rear--]
        if (rear < 0) rear = size - 1
        size--
        return tmp
    }

    open fun insertLeft(n: Int) {
        if (++front == rear) front++
        array[front] = n
        size++
    }

    open fun removeLeft(): Int {
        val tmp = remove()
        if (front >= size - 1) front = 0
        return tmp
    }
}
