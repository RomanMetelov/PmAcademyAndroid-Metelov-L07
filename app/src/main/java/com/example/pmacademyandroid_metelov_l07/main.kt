package com.example.pmacademyandroid_metelov_l07

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    var counter = AtomicInteger(0)

    val increaseCounter = Runnable {
        repeat(800)  {
            Thread.sleep(10)
            counter.incrementAndGet()
        }
    }
    val outputCounter = Runnable {
        repeat(12)  {
            Thread.sleep(1000)
            println(counter)
        }
    }

    val executor = Executors.newFixedThreadPool(5)

    repeat(4) {
        executor.execute(increaseCounter)
    }
    executor.execute(outputCounter)

    executor.shutdown()
    executor.awaitTermination(8000, TimeUnit.MILLISECONDS)
}