package chapter5

/**
 * Created by Jatzuk on 19.09.2018
 */

class CyclicalList<T> {
    var cur: Link<T>? = null
        private set

    private var size = 0

    fun insert(value: T) {
        val link = Link<T>(value)
        size++
        if (isEmpty()) {
            cur = link
            return
        } else {
//            var tmp = cur
            for (i in 0 until size - 1) cur?.next
            cur?.next = link
        }
    }

    fun step(): Link<T>? {
        cur = cur?.next
        return cur
    }

    fun find(value: T): Boolean {
        var ptr: Link<T>? = Link(value)
        while ({ ptr = step(); ptr }() != null) {
            if (ptr?.data == value) return true
        }
        return false
    }

    fun clear() {
        cur = null
    }

    fun isEmpty() = cur == null

    fun size(): Int {
        return 0
    }

    fun display() {
        if (isEmpty()) {
            println("Cyclical list is empty")
            return
        }
        var ptr: Link<T>? = cur
        while (ptr != null) {
            ptr.displayLink()
            ptr = cur?.next
        }

//        var ptr = cur
//        for (i in 0 until size) {
//            ptr?.displayLink()
//            ptr = ptr?.next
//        }
    }

    inner class Link<T>(internal val data: T) {
        var next: Link<T>? = null

        fun displayLink() {
            print("{$data} ")
        }
    }
}

fun main(args: Array<String>) {
    val cl = CyclicalList<Int>()
    cl.insert(1)
    cl.insert(2)
    cl.insert(3)
    cl.display()
}