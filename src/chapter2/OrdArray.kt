package chapter2

/**
 * Created by Jatzuk on 06.09.2018
 */

class OrdArray(max: Int) : HighArray(max) {
    override fun find(key: Int): Int {
        var lb = 0
        var ub = size - 1

        while (lb <= ub) {
            val cur = (lb + ub) / 2
            if (array[cur] == key) return cur
            else {
                if (array[cur] < key) lb = cur + 1
                else ub = cur - 1
            }
        }
        return -1
    }

    override fun insert(value: Int) {
        if (size == 0) super.insert(value)
        else {
            var lb = 0
            var ub = size - 1
            var cur = 0

            while (lb <= ub) {
                cur = (lb + ub) / 2
                if (ub - lb < 1) break
                if (array[cur] < value) lb = cur + 1
                else ub = cur - 1
            }

            for (i in size downTo cur + 1) {
                array[i] = array[i - 1]
            }

            array[cur] = value
            size++
        }
    }
}

fun main(args: Array<String>) {
    val a = OrdArray(7)
    a.insert(1)
    a.insert(2)
    a.insert(6)
//
    a.insert(4)
    a.insert(3)
    a.insert(0)

//    a.array[0] = 6
//    a.array[1] = 4
//    a.array[2] = 3
//    a.array[3] = 2
//    a.array[4] = 1
//    a.array[5] = 0
//    a.size = 6

//    a.insert(5)
//    a.insert(8)

//    for (i in 0 until 10) {
//        val n = (Math.random() * 10).toInt() + 1
//        print("$n ")
//        a.insert(n)
//    }
//    println()

    a.display()
}