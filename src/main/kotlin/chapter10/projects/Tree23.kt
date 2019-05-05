package chapter10.projects

import chapter10.DataItem
import chapter10.Node
import chapter10.Tree234

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

class Tree23 : Tree234() {
    override var root = Node(ORDER)

    override fun insert(value: Int) {
        var current = root
        val tmp = DataItem(value)
        while (true) {
            if (current.isLeaf()) break
            else current = getNextChild(current, value)
        }
        if (current.isFull()) split(current, tmp)
        else current.insertItem(tmp)
    }

    private fun split(node: Node, dataItem: DataItem): Node {
        val parent = node.parent
        val items = insertionSort(
            arrayOf(
                node.getItem(0)!!,
                node.getItem(1)!!,
                dataItem
            )
        )

        node.removeItem()
        node.removeItem()
        node.insertItem(items[0])
        val right = Node(ORDER).apply { insertItem(items[2]) }

        if (node == root) {
            Node(ORDER).apply {
                insertItem(items[1])
                connectChild(0, node)
                connectChild(1, right)
                root = this
            }
            return right
        } else if (parent!!.isFull()) {
            val sibling = split(parent, items[1])
            when (node) {
                parent.getChild(0) -> {
                    val b = parent.disconnectChild(1)
                    val c = parent.disconnectChild(2)
                    parent.connectChild(1, right)
                    sibling.apply {
                        connectChild(0, b)
                        connectChild(1, c)
                    }
                }
                parent.getChild(1) -> {
                    val c = parent.disconnectChild(2)
                    sibling.apply {
                        connectChild(0, right)
                        connectChild(1, c)
                    }
                }
                else -> {
                    parent.disconnectChild(2)
                    sibling.apply {
                        connectChild(0, node)
                        connectChild(1, right)
                    }
                }
            }
            return right
        } else {
            parent.insertItem(items[1])
            if (node == parent.getChild(0)) {
                parent.apply {
                    connectChild(2, parent.disconnectChild(1))
                    connectChild(1, right)
                }
            } else parent.connectChild(2, right)
        }
        return right
    }

    private fun insertionSort(array: Array<DataItem>): Array<DataItem> {
        fun swap(a: Int, b: Int) {
            val tmp = array[a]
            array[a] = array[b]
            array[b] = tmp
        }
        for (i in 1 until array.size) {
            val tmp = array[i]
            var j = i
            while (j > 0 && array[j - 1].data >= tmp.data) swap(j, j-- - 1)
            array[j] = tmp
        }
        return array
    }

    companion object {
        private const val ORDER = 3
    }
}
