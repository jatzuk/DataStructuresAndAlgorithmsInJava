package chapter5

/**
 * Created by Jatzuk on 22.09.2018
 */

class Stack<T> {
    private val cyclicalList = CyclicalList<T>()

    fun push(item: T) {
        cyclicalList.insert(item)
    }

    fun pop(): T? {
        if (isEmpty()) {
            println("Cyclical stack is empty")
            return null
        }
        cyclicalList.size--
        return cyclicalList.step()?.data
    }

    fun isEmpty() = cyclicalList.isEmpty()

    fun peek(): T? {
        if (isEmpty()) {
            println("Cyclical stack is empty")
            return null
        }
        return cyclicalList.cur?.next?.data
    }

    fun display() {
        cyclicalList.display()
    }
}
