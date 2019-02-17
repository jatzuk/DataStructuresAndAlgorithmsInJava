package chapter4

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 15.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class Deque(maxSize: Int) : Queue(maxSize) {
    open fun insertRight(n: Int) {
        insert(n)
    }

    open fun removeRight(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val tmp = array[rear--]
        if (rear < 0) rear = size - 1
        size--
        return tmp
    }

    open fun insertLeft(n: Int) {
        if (isFull()) {
            println("Queue is full")
            return
        }
        if (++front == rear) front++
        array[front] = n
        size++
    }

    open fun removeLeft(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val tmp = remove()
        if (front >= size - 1) front = 0
        return tmp
    }
}
