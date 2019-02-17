package chapter4

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Stack(maxSize: Int) : Deque(maxSize) {
    fun push(item: Int) {
        super.insert(item)
    }

    fun pop() = super.removeRight()

    fun peek() = array[rear]

    @Throws(NotImplementedError::class)
    override fun display() {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun insert(n: Int) {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun remove(): Int {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun removeRight(): Int {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun removeLeft(): Int {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun insertRight(n: Int) {
        throw NotImplementedError()
    }

    @Throws(NotImplementedError::class)
    override fun insertLeft(n: Int) {
        throw NotImplementedError()
    }
}
