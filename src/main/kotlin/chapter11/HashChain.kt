package chapter11

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

class HashChain(size: Int) {
    private val hashArray = Array(size) { SortedList() }

    fun displayTable() {
        repeat(hashArray.size) {
            print("$it. ")
            hashArray[it].displayList()
        }
    }

    private fun hashFun(key: Int) = key % hashArray.size

    fun insert(data: Int) {
        val hash = hashFun(data)
        hashArray[hash].insert(Link(data))
    }

    fun delete(key: Int) {
        val hash = hashFun(key)
        hashArray[hash].delete(key)
    }

    fun find(key: Int): Link? {
        val hash = hashFun(key)
        return hashArray[hash].find(key)
    }

   inner class Link(val data: Int) {
        var next: Link? = null

        fun displayLink() {
            print("$data ")
        }
    }

    inner class SortedList {
        private var first: Link? = null

        fun insert(link: Link) {
            val key = link.data
            var prev: Link? = null
            var current = first
            while (current != null && key > current.data) {
                prev = current
                current = current.next
            }
            if (prev == null) first = link
            else prev.next = current
            link.next = current
        }

        fun delete(key: Int) {
            var prev: Link? = null
            var current = first
            while (current != null && key != current.data) {
                prev = current
                current = current.next
            }
            if (prev == null) first = first?.next
            else prev.next = current?.next
        }

        fun find(key: Int): Link? {
            var current = first
            while (current != null && current.data <= key) {
                if (current.data == key) return current
                current = current.next
            }
            return null
        }

        fun displayList() {
            print("List (first-->last): ")
            var current = first
            while (current != null) {
                current.displayLink()
                current = current.next
            }
            println()
        }
    }
}
