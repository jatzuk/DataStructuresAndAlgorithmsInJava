package chapter4

import sun.reflect.generics.reflectiveObjects.NotImplementedException


/**
 * Created by Jatzuk on 17.09.2018
 */

class Stack(maxSize: Int) : Deque(maxSize) {
    fun push(item: Int) {
        insert(item)
    }

    fun pop() = removeRight()

    fun peek() = array[rear]

    @Throws(NotImplementedException::class)
    override fun display() {
        throw NotImplementedException()
    }
}
