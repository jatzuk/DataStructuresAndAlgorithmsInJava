package chapter9

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 30.03.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

abstract class AbstractNode<T, N>(val data: T) : Comparable<AbstractNode<T, N>> {
    abstract var left: N?
    abstract var right: N?

    open fun display() {
        print(data)
    }

    override fun compareTo(other: AbstractNode<T, N>) = data - other.data

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            javaClass != other?.javaClass -> false
            else -> data == (other as AbstractNode<*, *>).data
        }
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result *= 31 * 2
        return result
    }

    private operator fun <T> T.minus(data: T) = when (data) {
        is Int -> this as Int - data
        is Char -> this as Char - data
        else -> 0
    }
}
