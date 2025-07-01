package com.example.testapp.OtherLearning

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val supervisor = SupervisorJob()
        val scope = CoroutineScope(Dispatchers.Default + supervisor)

        scope.launch {
            throw RuntimeException("Failure in one child")
        }

        scope.launch {
            delay(1000)
            println("Other child still running")
        }

        delay(1500)
    }
}