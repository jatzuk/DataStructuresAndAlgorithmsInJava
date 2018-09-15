package chapter4

/**
 * Created by Jatzuk on 15.09.2018
 */

class Deque(maxSize: Int) : Queue(maxSize) {
    fun insertRight(n: Int) {
        insert(n)
    }

    fun removeRight(): Int {
        val tmp = array[rear--]
        if (rear <= 0) rear = size - 1
        size--
        return tmp
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
