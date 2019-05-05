package chapter10

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 30.04.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Node(private val order: Int) {
    private val childArray = arrayOfNulls<Node>(order)
    private val itemArray = arrayOfNulls<DataItem>(order - 1)
    var numItems = 0
        private set
    var parent: Node? = null
        private set

    fun isLeaf() = childArray[0] == null

    fun getItem(index: Int) = itemArray[index]

    fun isFull() = numItems == order - 1

    fun getChild(childNum: Int) = childArray[childNum]

    fun connectChild(childNum: Int, child: Node?) {
        childArray[childNum] = child
        child?.let { it.parent = this }
    }

    fun disconnectChild(childNum: Int): Node? {
        val tmp = childArray[childNum]
        childArray[childNum] = null
        return tmp
    }

    fun findItem(key: Int): Int {
        for (i in 0 until order - 1) {
            if (itemArray[i] == null) break
            else if (itemArray[i]!!.data == key) return i
        }
        return -1
    }

    fun insertItem(newItem: DataItem): Int {
        numItems++
        val newKey = newItem.data
        for (i in order - 2 downTo 0) {
            if (itemArray[i] != null) {
                val itsKey = itemArray[i]!!.data
                if (newKey < itsKey) itemArray[i + 1] = itemArray[i]
                else {
                    itemArray[i + 1] = newItem
                    return i + 1
                }
            }
        }
        itemArray[0] = newItem
        return 0
    }

    fun removeItem(): DataItem {
        val tmp = itemArray[numItems - 1]
        itemArray[numItems-- - 1] = null
        return tmp!!
    }

    fun displayNode() {
        for (i in 0 until numItems) itemArray[i]!!.displayItem()
        println("/")
    }
}

class DataItem(val data: Int) {
    fun displayItem() {
        print("/$data")
    }
}
