package chapter11.projects

import chapter11.AbstractHash

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 10.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashFolding(size: Int) : AbstractHash<Int>(size) {
    @Suppress("NAME_SHADOWING")
    public override fun hashFun(key: Int): Int {
        var groupSize = 1
        var arraySize = array.size
        var hash = 0
        var key = key

        while (arraySize > 1) {
            groupSize *= 10
            arraySize /= 10
        }

        while (key > 0) {
            hash += key % groupSize
            key /= groupSize
        }
        return hash % groupSize
    }
}
