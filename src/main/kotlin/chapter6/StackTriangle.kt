package chapter6

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

var number = 0
var answer = 0
var stack: StackX? = null
var codePart = 0
var params: Params? = null

class Params(val n: Int, val returnAddress: Int)

open class StackX(maxSize: Int) {
    private val stackArray = arrayOfNulls<Params>(maxSize)
    private var top = -1

    fun push(p: Params) {
        stackArray[++top] = p
    }

    fun pop() = stackArray[top--]

    fun peek() = stackArray[top]
}

fun recTriangle() {
    stack = StackX(10_000)
    codePart = 1
    while (!step()) {

    }
}

fun step(): Boolean {
    when (codePart) {
        1 -> {
            params = Params(number, 6)
            stack?.push(params!!)
            codePart = 2
        }
        2 -> {
            params = stack?.peek()
            if (params?.n == 1) {
                answer = 1
                codePart = 5
            } else codePart = 3
        }
        3 -> {
            val newParams = Params(params!!.n - 1, 4)
            stack?.push(newParams)
            codePart = 2
        }
        4 -> {
            params = stack?.peek()
            answer += params!!.n
            codePart = 5
        }
        5 -> {
            params = stack?.peek()
            codePart = params!!.returnAddress
            stack?.pop()
        }
        6 -> return true
    }
    return false
}
