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

class DoubleHash(size: Int) : Hash(size) {
    private fun hashFun2(key: Int) = SEED - key % SEED

    fun insert(key: Int, item: DataItem) {
        var hashVal = hashFun(key)
        val stepSize = hashFun2(key)
        while (hashArray[hashVal] != null && hashArray[hashVal]?.key != null) {
            hashVal += stepSize
            hashVal %= size
        }
        hashArray[hashVal] = item
    }

    override fun delete(key: Int): DataItem? {
        var hashVal = hashFun(key)
        val stepSize = hashFun2(key)
        while (hashArray[hashVal]?.key != null) {
            if (hashArray[hashVal]?.key == key) {
                val tmp = hashArray[hashVal]
                hashArray[hashVal] = null
                return tmp
            }
            hashVal += stepSize
            hashVal %= size
        }
        return null
    }

    override fun find(key: Int): DataItem? {
        var hashVal = hashFun(key)
        val stepSize = hashFun2(key)
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]?.key == key) return hashArray[hashVal]
            hashVal += stepSize
            hashVal %= size
        }
        return null
    }

    companion object {
        private const val SEED = 5
    }
}
