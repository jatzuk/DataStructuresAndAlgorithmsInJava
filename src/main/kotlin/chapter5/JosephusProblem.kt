package chapter5

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 22.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

fun josephusProblem(size: Int, step: Int, start: Int): Int? {
    val cl = CyclicalList<Int>()
    for (i in size downTo 1) cl.insert(i)

    while (cl.size > 1) {
        for (j in start until size) {
            cl.step()
            if (j % step == 0) {
                val corpse = cl.remove()
                print("$corpse ")
                break
            }
        }
    }
    return cl.remove()
}
