package com.example.testapp.OtherLearning

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        supervisorScope {
            launch {
                delay(100)
                println("Child 1 fails")
                throw RuntimeException("Error in Child 1")
            }

            launch {
                delay(200)
                println("Child 2 completes")
            }
        }
        println("SupervisorScope done")
    }
}