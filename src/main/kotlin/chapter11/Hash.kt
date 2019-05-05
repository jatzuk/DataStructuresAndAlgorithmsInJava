package chapter11

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 05.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

open class Hash(val size: Int) {
    protected val hashArray = arrayOfNulls<DataItem>(size)

    fun displayTable() {
        print("Table: ")
        repeat(size) { print("${hashArray[it]?.key ?: "**"} ") }
        println()
    }

    protected fun hashFun(key: Int) = key % size

    fun insert(item: DataItem) {
        val key = item.key
        var hashVal = hashFun(key)
        while (hashArray[hashVal] != null && hashArray[hashVal]?.key != null) {
            hashVal++
            hashVal %= size
        }
        hashArray[hashVal] = item
    }

    open fun delete(key: Int): DataItem? {
        var hashVal = hashFun(key)
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.key == key) {
                val tmp = hashArray[hashVal]
                hashArray[hashVal] = null
                return tmp
            }
            hashVal++
            hashVal %= size
        }
        return null
    }

    open fun find(key: Int): DataItem? {
        var hashVal = hashFun(key)
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.key == key) return hashArray[hashVal]
            hashVal++
            hashVal %= size
        }
        return null
    }
}

class DataItem(val key: Int)
