package chapter4

import java.util.*
import java.util.concurrent.Executors

/**
 * Created by Jatzuk on 18.09.2018
 */

class Customer(private val id: Int, private val amountOfPurchases: Float) {
    override fun toString(): String {
        return "Customer $id for $amountOfPurchases"
    }
}

class Shop(private val firstQueue: LinkedList<Customer>, private val secondQueue: LinkedList<Customer>) : Thread() {
    companion object {
        var shopClosed = false
    }

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
}

class CashBox(private val firstQueue: LinkedList<Customer>, private val secondQueue: LinkedList<Customer>) : Thread() {
    override fun run() {
        while (!Shop.shopClosed) {
            while (firstQueue.isNotEmpty()) {
                synchronized(firstQueue) {
                    val buyer = firstQueue.remove()
                    println("   first queue $buyer living shop")
                    Thread.sleep((Math.random() * 4200 + 100).toLong())
                }
            }

            while (secondQueue.isNotEmpty()) {
                synchronized(secondQueue) {
                    val buyer = secondQueue.remove()
                    println("   second queue $buyer living shop")
                    Thread.sleep((Math.random() * 4200 + 100).toLong())
                }
            }
            Thread.yield()
        }
        println("All customers were served\nshop closed")
    }
}

fun main(args: Array<String>) {
    val firstQueue = LinkedList<Customer>()
    val secondQueue = LinkedList<Customer>()

    val threadPoolExecutor = Executors.newFixedThreadPool(2)
    threadPoolExecutor.execute(Shop(firstQueue, secondQueue))
    threadPoolExecutor.execute(CashBox(firstQueue, secondQueue))
    threadPoolExecutor.shutdown()
}