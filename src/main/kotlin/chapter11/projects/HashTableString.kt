package chapter11.projects

import chapter11.AbstractHash

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

class HashTableString(size: Int): AbstractHash<String>(size) {
    override fun hashFun(key: String): Int {
        var hash = 0
        repeat(key.length) {
            val letter = key[it].toLowerCase().toInt() - 96
            hash = (hash * 27 + letter) % array.size
        }
        return hash
    }
}
