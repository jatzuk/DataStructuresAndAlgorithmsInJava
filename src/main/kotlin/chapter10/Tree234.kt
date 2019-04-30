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

class Tree234 {
    private var root = Node()

    fun find(key: Int): Int {
        var current = root as Node?
        while (true) {
            val childNumber = current!!.findItem(key)
            when {
                childNumber != -1 -> return childNumber
                current.isLeaf() -> return -1
                else -> current = getNextChild(current, key)
            }
        }
    }

    fun insert(value: Int) {
        var current = root
        val tmp = DataItem(value)
        while (true) {
            if (current.isFull()) {
                split(current)
                current = current.parent!!
                current = getNextChild(current, value)
            } else if (current.isLeaf()) break
            else current = getNextChild(current, value)
        }
        current.insertItem(tmp)
    }

    private fun split(node: Node) {
        val itemC = node.removeItem()
        val itemB = node.removeItem()
        val child2 = node.disconnectChild(2)
        val child3 = node.disconnectChild(3)
        val parent: Node

        if (node == root) {
            root = Node()
            parent = root
            root.connectChild(0, node)
        } else parent = node.parent!!

        val itemIndex = parent.insertItem(itemB)
        val n = parent.numItems
        for (i in n - 1 downTo itemIndex + 1) {
            val tmp = parent.disconnectChild(i)
            parent.connectChild(i + 1, tmp)
        }

        parent.connectChild(itemIndex + 1, Node().apply {
            insertItem(itemC)
            connectChild(0, child2)
            connectChild(1, child3)
        })
    }

    private fun getNextChild(node: Node, value: Int): Node {
        var i = 0
        while (i < node.numItems) {
            if (value < node.getItem(i)!!.data) return node.getChild(i)!!
            i++
        }
        return node.getChild(i)!!
    }

    fun displayTree() {
        recDisplayTree(root, 0, 0)
    }

    private fun recDisplayTree(node: Node, level: Int, childNumber: Int) {
        print("level-$level child-$childNumber ")
        node.displayNode()
        for (i in 0 until node.numItems + 1) {
            val nextNode = node.getChild(i)
            if (nextNode != null) recDisplayTree(nextNode, level + 1, i)
            else return
        }
    }
}
