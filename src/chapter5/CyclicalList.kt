package chapter5

/**
 * Created by Jatzuk on 19.09.2018
 */

class CyclicalList<T> {
    var cur: Link<T>? = null
//        private set
    private var size = 0

    fun insert(value: T) {
        val link = Link(value)
        if (isEmpty()) {
            cur = link
            cur?.next = cur
        } else {
            link.next = cur?.next
            cur?.next = link
        }
        size++
    }

    fun remove(): T? {
        if (isEmpty()) {
            println("Cyclical list is empty")
            return null
        }
        val tmp = cur?.next?.data
        cur?.next = cur?.next?.next
        size--
        return tmp
    }

    fun step(): Link<T>? {
        val tmp = cur
        cur = cur?.next
        return tmp
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
        var s = size
        while (s-- > 0) {
            ptr?.displayLink()
            ptr = ptr?.next
        }
        println()
    }

    inner class Link<out T>(internal val data: T) {
        var next: Link<T>? = null

        fun displayLink() {
            print("{$data} ")
        }
    }
}

fun main(args: Array<String>) {
    val cl = CyclicalList<Int>()
    cl.insert(2)
    cl.insert(1)
    cl.display()
//    val t = cl.remove()
//    println(t)
//    cl.display()
}