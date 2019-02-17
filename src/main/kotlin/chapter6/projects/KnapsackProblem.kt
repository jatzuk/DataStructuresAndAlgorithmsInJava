package chapter6.projects

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 17.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class KnapsackProblem {
    val array = arrayOf(11, 8, 7, 6, 5)
    val result = ArrayList<Int>()

    fun knapsackProblem(index: Int, target: Int) {
        val cur = array[index]
        val nt = target - cur
        if (cur == target) {
            println(result)
            return
        } else {
            if (nt < 0) {
                result.removeAt(result.size - 1)
                return
            } else {
                for (j in index + 1 until array.size) {
                    result.add(array[j])
                    knapsackProblem(j, nt)
                }
            }
        }
    }
}
