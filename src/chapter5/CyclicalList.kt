package chapter5

/**
 * Created by Jatzuk on 19.09.2018
 */

class CyclicalList<T> {
    var cur: Link<T>? = null
        private set

    fun insert(value: T) {
        val link = Link<T>(value)
        link.next = cur
        cur = link
    }

    fun step(): Link<T>? {
        cur = cur?.next
        return cur
    }

    fun find(value: T): Boolean {
        if (isEmpty()) {
            println("Cyclical list is empty")
            return false
        }
        var ptr: Link<T>? = Link(value)
        while (ptr != null) {
            if (ptr.data == value) return true
            ptr = ptr.next
        }
        return false
    }

    fun clear() {
        cur = null
    }

    fun isEmpty() = cur == null

    fun size(): Int {
        return if (isEmpty()) 0
        else {
            var size = 0
            var ptr = cur
            while (ptr != null) {
                size++
                ptr = ptr.next
            }
            size
        }
    }

    fun display() {
        if (isEmpty()) {
            println("Cyclical list is empty")
            return
        }
        var ptr = cur
        while (ptr != null) {
            ptr.displayLink()
            ptr = ptr.next
        }
    }

    inner class Link<T>(internal val data: T) {
        var next: Link<T>? = null

        fun displayLink() {
            print("{$data} ")
        }
    }
}
