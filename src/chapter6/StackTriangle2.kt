package chapter6

/**
 * Created by Jatzuk on 24.10.2018
 */

class StackX2(maxSize: Int) {
    private val stackArray = Array(maxSize) { 0 }
    private var top = -1

    fun push(value: Int) {
        stackArray[++top] = value
    }

    fun pop() = stackArray[top--]

    fun isEmpty() = top == -1
}

fun stackTriangle() {
    val stack = StackX2(10_000)
    answer = 0
    while (number > 0) stack.push(number--)
    while (!stack.isEmpty()) answer += stack.pop()
}
