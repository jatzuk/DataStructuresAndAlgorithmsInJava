package chapter5

/**
 * Created by Jatzuk on 22.09.2018
 */

fun josephusProblem(size: Int, step: Int, start: Int) {
    val cl = CyclicalList<Int>()
    for (i in size downTo 1) cl.insert(i)
    cl.cur = cl.cur?.next


    for (i in 0 until size) {
        for (j in start until size) {
            cl.step()
            if (j % step == 0) {
                val corpse = cl.remove()
                print("$corpse ")
                break
            }
        }
    }
}

fun main(args: Array<String>) {
    josephusProblem(7, 3, 1)
}