package Coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.system.measureTimeMillis


fun main() = runBlocking {

    println("I am from main- START and thread name is--- ${Thread.currentThread().name}")

    var time = measureTimeMillis {
         getmessage()
        sentMessage()
    }

    println("I am from main- END and thread name is--- ${Thread.currentThread().name} time taken to finish is $time")
}

// as you can see the current execution of your program is by default TopTOBottom and sequential execution.
suspend fun getmessage() {
    delay(1000)
    println("I am getting message")
}

suspend fun sentMessage() {
    delay(10000)
    println("I am sending message")
}