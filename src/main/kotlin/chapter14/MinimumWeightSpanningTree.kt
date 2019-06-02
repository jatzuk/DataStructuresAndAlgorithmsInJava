package chapter14

import chapter13.MatrixGraph

/* 
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 02.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class MinimumWeightSpanningTree(maxVerts: Int) : MatrixGraph(maxVerts) {
    private val queue = PriorityQueue(maxVerts)

    override fun addVertex(label: Char) {
        vertexes[verts++] = WeightVertex(label)
    }

    fun addEdge(start: Int, end: Int, weight: Int) {
        adjustMatrix[start][end] = weight
        adjustMatrix[end][start] = weight
    }

    @Throws(IllegalArgumentException::class)
    fun mwsp(): Map<Char, Char> {
        val map = hashMapOf<Char, Char>()
        var currentVertex = 0
        var treeSize = 0

        while (treeSize < verts - 1) {
            (vertexes[currentVertex] as WeightVertex).isInTree = true
            treeSize++

            for (i in 0 until verts) {
                if (i == currentVertex || (vertexes[i] as WeightVertex).isInTree) continue
                val distance = adjustMatrix[currentVertex][i]
                if (distance == 0) continue
                queue.offer(i, distance, currentVertex)
            }

            if (queue.isEmpty()) throw IllegalArgumentException("GRAPH NOT CONNECTED")
            val edge = queue.removeMin()
            val sourceVertex = edge!!.sourceVertex
            currentVertex = edge.destinationVertex
            map[vertexes[sourceVertex]!!.label] = vertexes[currentVertex]!!.label
        }
        resetFlags()
        return map
    }

    private fun resetFlags() {
        vertexes.forEach { (it as WeightVertex?)?.isInTree = false }
    }

    @Throws(NotImplementedError::class)
    override fun addEdge(start: Int, end: Int) {
        throw NotImplementedError("NOT IMPLEMENTED, use: addEdge(start: Int, end: Int, weight: Int)")
    }

    private inner class PriorityQueue(size: Int) {
        private val array = arrayOfNulls<Edge>(size)
        private var size = 0

        fun insert(item: Edge) {
            var i = 0
            for (j in i until size) {
                if (item.distance >= array[j]!!.distance) break
                i++
            }
            for (j in size - 1 downTo i) array[j + 1] = array[j]
            array[i] = item
            size++
        }

        fun offer(vertex: Int, distance: Int, currentVertex: Int) {
            val index = queue.find(vertex)
            if (index != -1) {
                if (queue.peekAt(index)!!.distance > distance) {
                    with(queue) {
                        removeAt(index)
                        insert(Edge(currentVertex, vertex, distance))
                    }
                }
            } else queue.insert(Edge(currentVertex, vertex, distance))
        }

        fun removeMin() = array[--size]

        fun removeAt(index: Int) {
            for (i in index until size - 1) array[i] = array[i + 1]
            size--
        }

        fun peekMin() = array[size - 1]

        fun isEmpty() = size == 0

        fun peekAt(index: Int) = array[index]

        fun find(index: Int): Int {
            repeat(size) { if (array[it]!!.destinationVertex == index) return it }
            return -1
        }
    }

    class WeightVertex<T>(label: T) : BaseVertex<T>(label) {
        var isInTree = false
    }

    class Edge(val sourceVertex: Int, val destinationVertex: Int, val distance: Int)
}
