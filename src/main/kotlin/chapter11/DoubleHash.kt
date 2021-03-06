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

class DoubleHash(size: Int) : AbstractHash<Int>(size) {
    override fun insert(item: DataItem<Int>) {
        throw NotImplementedError("use this instead: fun insert(key: Int, item: DataItem<Int>)")
    }

    fun insert(key: Int, item: DataItem<Int>) {
        var hash = hashFun(key)
        val stepSize = hashFun2(key)
        while (array[hash] != null && array[hash]?.key != null) {
            hash += stepSize
            hash %= array.size
        }
        array[hash] = item
    }

    override fun delete(key: Int): DataItem<Int>? {
        var hash = hashFun(key)
        val stepSize = hashFun2(key)
        while (array[hash]?.key != null) {
            if (array[hash]?.key == key) {
                val tmp = array[hash]
                array[hash] = null
                return tmp
            }
            hash += stepSize
            hash %= array.size
        }
        return null
    }

    override fun find(key: Int): DataItem<Int>? {
        var hash = hashFun(key)
        val stepSize = hashFun2(key)
        while (array[hash] != null) {
            if (array[hash]?.key == key) return array[hash]
            hash += stepSize
            hash %= array.size
        }
        return null
    }

    override fun hashFun(key: Int): Int = key % array.size

    private fun hashFun2(key: Int) = SEED - key % SEED

    companion object {
        private const val SEED = 5
    }
}
