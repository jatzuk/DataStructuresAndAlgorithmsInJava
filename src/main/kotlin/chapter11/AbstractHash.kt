package chapter11

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 08.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

abstract class AbstractHash<T>(size: Int) {
    protected var array = arrayOfNulls<DataItem<T>>(size)

    open fun displayTable() {
        print("${this::class.java.simpleName} Table: ")
        repeat(array.size) { print("${array[it]?.key ?: "**"} ") }
        println()
    }

    open fun insert(item: DataItem<T>) {
        var hash = hashFun(item.key)
        while (array[hash] != null && array[hash]?.key != null) {
            hash++
            hash %= array.size
        }
        array[hash] = item
    }

    open fun delete(key: T): DataItem<T>? {
        var hash = hashFun(key)
        while (array[hash] != null) {
            if (array[hash]?.key == key) {
                val tmp = array[hash]
                array[hash] = null
                return tmp
            }
            hash++
            hash %= array.size
        }
        return null
    }

    open fun find(key: T): DataItem<T>? {
        var hash = hashFun(key)
        while (array[hash] != null) {
            if (array[hash]?.key == key) return array[hash]
            hash++
            hash %= array.size
        }
        return null
    }

    protected abstract fun hashFun(key: T): Int

    class DataItem<T>(val key: T)
}

