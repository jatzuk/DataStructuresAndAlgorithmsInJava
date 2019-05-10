package chapter11.projects

import chapter11.AbstractHash

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 11.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class RehashTable(size: Int) : AbstractHash<Int>(size) {
    private var inserts = 0

    override fun hashFun(key: Int) = key % array.size

    override fun insert(item: DataItem<Int>) {
        if ((inserts + 1).toFloat() / array.size >= LOAD_FACTOR) rehash(item)
        else {
            super.insert(item)
            inserts++
        }
    }

    private fun rehash(item: DataItem<Int>) {
        val tmp = array
        array = arrayOfNulls(tmp.size * 2)
        inserts = 0
        repeat(tmp.size) { i -> tmp[i]?.let { insert(it) } }
        insert(item)
    }

    companion object {
        private const val LOAD_FACTOR = 0.5f
    }
}
