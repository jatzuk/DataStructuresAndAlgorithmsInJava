package chapter5

/**
 * Created by Jatzuk on 18.09.2018
 */

class LinkList {
    private var first: Link? = null
    private var last: Link? = null

    fun insertFirst(value: Int) {
        val link = Link(value)
        if (isEmpty()) last = link
        else first?.prev = link
        link.next = first
        first = link
    }

    fun insertLast(value: Int) {
        val link = Link(value)
        if (isEmpty()) first = link
        else {
            last?.next = link
            link.prev = last
        }
        last = link
    }

    fun deleteFirst(): Link? {
        if (isEmpty()) {
            println("Link list is empty")
            return null
        }
        val tmp = first
        if (first?.next == null) last = null
        else first?.next?.prev = null
        first = first?.next
        return tmp
    }

    fun deleteLast(): Link? {
        if (isEmpty()) {
            println("Link list is empty")
            return null
        }
        val tmp = last
        if (first?.next == null) first = null
        else last?.prev?.next = null
        last = last?.prev
        return tmp
    }

    fun insertAfter(key: Int, value: Int): Boolean {
        if (isEmpty()) {
            println("Link list is empty")
            return false
        }
        var current = first
        while (current?.data != key) {
            current = current?.next
            if (current == null) return false
        }

        val link = Link(value)
        if (current == last) {
            link.next = null
            last = link
        } else {
            link.next = current.next
            current.next?.prev = link
        }
        link.prev = current
        current.next = link
        return true
    }

    fun deleteKey(key: Int): Link? {
        var current = first
        while (current?.data != key) {
            current = current?.next
            if (current == null) return null
        }
        if (current == first) first = current.next
        else current.prev?.next = current.next
        if (current == last) last = current.prev
        else current.next?.prev = current.prev
        return current
    }

    fun find(key: Int): Link? {
        if (isEmpty()) {
            println("Link list is empty")
            return null
        }
        var current = first
        while (current?.data != key) {
            if (current?.next == null) return null
            else current = current.next
        }
        return current
    }

    fun delete(key: Int): Link? {
        if (isEmpty()) {
            println("Link list is empty")
            return null
        }
        var current = first
        var previous = first
        while (current?.data != key) {
            if (current?.next == null) return null
            else {
                previous = current
                current = current.next
            }
        }
        if (current == first) first = first?.next
        else previous?.next = current.next
        return current
    }

    fun displayList() {
        if (isEmpty()) {
            println("Link list is empty")
            return
        }
        var current = first
        while (current != null) {
            current.displayLink()
            current = current.next
        }
        println()
    }

    fun displayForward() {
        if (isEmpty()) {
            println("Link list is empty")
            return
        }
        println("first --> last")
        var current = first
        while (current != null) {
            current.displayLink()
            current = current.next
        }
        println()
    }

    fun displayBackward() {
        if (isEmpty()) {
            println("Link list is empty")
            return
        }
        var current = last
        while (current != null) {
            current.displayLink()
            current = current.prev
        }
        println()
    }

    fun isEmpty() = first == null

    inner class Link(val data: Int) {
        var next: Link? = null
        var prev: Link? = null

        fun displayLink() {
            print("{$data} ")
        }
    }
}
