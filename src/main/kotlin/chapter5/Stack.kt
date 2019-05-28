package chapter5

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 22.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Stack<T> {
    val cyclicalList = CyclicalList<T>()

    fun push(item: T) {
        cyclicalList.insert(item)
    }

    fun pop() = cyclicalList.remove()

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
