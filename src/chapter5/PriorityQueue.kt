package chapter5

/**
 * Created by Jatzuk on 19.09.2018
 */

class PriorityQueue {
    private val list = LinkList()

    fun insert(value: Int) {
        list.insertLast(value)
    }

    fun remove(): Int {
        if (isEmpty()) {
            println("Priority Queue is empty")
            return -1
        }
        var min = Int.MAX_VALUE
        var cur = list.first
        var elem = list.first
        while (cur != null) {
            if (cur.data < min) {
                min = cur.data
                elem = cur
            }
            cur = cur.next
        }

        if (elem == list.first) list.first = null
        else elem?.prev?.next = cur

        return elem!!.data
    }

    fun peekFront(): Int? {
        return list.first?.data
    }

    fun peekBack(): Int? {
        return list.last?.data
    }

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
