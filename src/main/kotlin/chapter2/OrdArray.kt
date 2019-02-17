package chapter2

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 06.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class OrdArray(max: Int) : HighArray(max) {
    override fun find(key: Int): Int {
        var lb = 0
        var ub = size - 1

        while (true) {
            val cur = (lb + ub) / 2
            if (array[cur] == key) return cur
            else if (lb > ub) return lb
            else {
                if (array[cur] < key) lb = cur + 1
                else ub = cur - 1
            }
        }
    }

    override fun insert(value: Int) {
        val cur = find(value)

        for (i in size downTo cur + 1) array[i] = array[i - 1]

        array[cur] = value
        size++
    }

    override fun delete(value: Int): Boolean {
        val n = find(value)
        return if (n == size) false
        else {
            for (i in n until size - 1) array[i] = array[i + 1]
            size--
            true
        }
    }

    fun merge(second: OrdArray) {
        val merged = OrdArray(size + second.size)
        val maxSize = merged.array.size
        var fp = 0
        var sp = 0
        var mp = 0

        mainLoop@ while (mp < maxSize) {
            when {
                sp == second.size -> {
                    for (i in mp until maxSize) merged.insert(array[sp++])
                    break@mainLoop
                }
                fp == size -> {
                    for (i in mp until maxSize) merged.insert(array[sp++])
                    break@mainLoop
                }
                else -> {
                    val n = if (array[fp] > second.array[sp]) second[sp++] else array[fp++]
                    merged.insert(n)
                    mp++
                }
            }
        }
        merged.display()
    }
}
