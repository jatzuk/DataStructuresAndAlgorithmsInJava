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

class Hash(size: Int) : AbstractHash<Int>(size) {
    fun quadraticProbing(item: DataItem<Int>) {
        val key = item.key
        var hash = hashFun(key)
        var pow = 1
        while (array[hash] != null && array[hash]?.key != null) {
            hash += (pow * pow++)
            hash %= array.size
        }
        array[hash] = item
    }

    override fun hashFun(key: Int): Int = key % array.size
}
