package chapter4

import sun.reflect.generics.reflectiveObjects.NotImplementedException


/**
 * Created by Jatzuk on 17.09.2018
 */

class Stack(maxSize: Int) : Deque(maxSize) {
    fun push(item: Int) {
        super.insert(item)
    }

    fun pop() = super.removeRight()

    fun peek() = array[rear]

    @Throws(NotImplementedException::class)
    override fun display() {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun insert(n: Int) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun remove(): Int {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun removeRight(): Int {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun removeLeft(): Int {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun insertRight(n: Int) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun insertLeft(n: Int) {
        throw NotImplementedException()
    }
}
