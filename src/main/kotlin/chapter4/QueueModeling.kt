package chapter4

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.Executors

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 18.09.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class Customer(private val id: Int, private val amountOfPurchases: Float) {
    override fun toString(): String {
        return "Customer $id for $amountOfPurchases"
    }
}

class Shop(
    private val firstQueue: LinkedList<Customer>,
    private val secondQueue: LinkedList<Customer>
) : Thread() {
    override fun run() {
        for (i in 0 until 10) {
            var buyer = Customer(i, (Math.random() * 2001).toFloat() + 1)
            synchronized(firstQueue) {
                println("Adding new $buyer to first queue")
                firstQueue.add(buyer)
                Thread.sleep((Math.random() * 2100 + 100).toLong())
            }
            synchronized(secondQueue) {
                buyer = Customer(i, (Math.random() * 2001).toFloat() + 1)
                println("Adding new $buyer to second queue")
                secondQueue.add(buyer)
                Thread.sleep((Math.random() * 2100 + 100).toLong())
            }
            Thread.yield()
        }
        shopClosed = true
    }

    companion object {
        var shopClosed = false
    }
}

class CashBox(
    private val firstQueue: LinkedList<Customer>,
    private val secondQueue: LinkedList<Customer>
) : Thread() {
    override fun run() {
        while (!Shop.shopClosed) {
            while (firstQueue.isNotEmpty()) {
                synchronized(firstQueue) {
                    val buyer = firstQueue.remove()
                    println("\tfirst queue $buyer living shop")
                    Thread.sleep((Math.random() * 4200 + 100).toLong())
                }
            }

            while (secondQueue.isNotEmpty()) {
                synchronized(secondQueue) {
                    val buyer = secondQueue.remove()
                    println("\tsecond queue $buyer living shop")
                    Thread.sleep((Math.random() * 4200 + 100).toLong())
                }
            }
            Thread.yield()
        }
        println("All customers were served\nshop closed")
    }
}

fun main() = runBlocking<Unit> {
    with(Executors.newFixedThreadPool(2)) {
        launch {
            val firstQueue = LinkedList<Customer>()
            val secondQueue = LinkedList<Customer>()
            execute(Shop(firstQueue, secondQueue))
            execute(CashBox(firstQueue, secondQueue))
            shutdown()
        }
    }
}
