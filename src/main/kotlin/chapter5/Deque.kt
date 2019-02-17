package chapter5

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 19.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Deque {
    private val list = LinkList()

    fun insertRight(n: Int) {
        list.insertLast(n)
    }

    fun removeRight() = list.deleteLast()


    fun insertLeft(n: Int) {
        list.insertFirst(n)
    }

    fun removeLeft() = list.deleteFirst()

    fun peekFront() = list.first?.data

    fun peekBack() = list.last?.data

    fun isEmpty() = list.isEmpty()

    fun size(): Int {
        var ptr = list.first
        var size = 0
        while (ptr != null) {
            size++
            ptr = ptr.next
        }
        return size
    }

    fun display() {
        list.displayList()
    }
}
