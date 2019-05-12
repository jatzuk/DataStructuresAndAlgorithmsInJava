package chapter11.projects

import chapter8.BinaryTree

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 12.05.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HashTree(size: Int) {
    private val array = arrayOfNulls<BinaryTree<Int>>(size)

    fun insert(key: Int) {
        val hash = hashFun(key)
        if (array[hash] == null) array[hash] = BinaryTree()
        else if (find(key) != null) {
            throw IllegalArgumentException("Hash table already contains element with key $key")
        }
        array[hash]!!.insert(key)
    }

    fun delete(key: Int): Int? {
        val (node, hash) = find(key)!!
        return if (node != null) {
            array[hash]!!.delete(key)
            node.data
        } else null
    }

    fun find(key: Int): Pair<BinaryTree<Int>.Node?, Int>? {
        val hash = hashFun(key)
        val node = array[hash]?.find(key)
        return if (node != null) Pair(node, hash)
        else null
    }

    fun displayTable() {
        println("${this::class.java.simpleName} Table:")
        repeat(array.size) {
            print("index: $it")
            array[it]?.displayTree()
        }
        println()
    }

    private fun hashFun(key: Int) = key % array.size
}
