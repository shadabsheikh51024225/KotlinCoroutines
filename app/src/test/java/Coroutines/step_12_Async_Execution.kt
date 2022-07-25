package Coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {

    println("I am from main- START and thread name is--- ${Thread.currentThread().name}")

    var time = measureTimeMillis {
        // if we use async then execution of this program will be in async order not default sequential.
        // also with async you can get deferred object. (read again deferred object).
        // now this methods are gonna execute in different thread and but run concurrent.
        // this is how you can achieve concurrency or say parallel execution.
        var getm:Deferred<Unit> = async {getmessageAsync()}
        var gets:Deferred<Unit> = async {sentMessageAsync()}
        //WE CAN ALSO USE LAUNCH COROUTINE BUILDERS TO GET THE CONCURRENCY , BUT IN OUR CURRENT PROGRAM WE NEED,
        // A RETURN VALUE AND LAUNCH DOES NOT PROVIDE RETURN VALUE AND THAT'S THE DIFFERANCE BETWEEN THEM.
    }

    println("I am from main- END and thread name is--- ${Thread.currentThread().name} time taken to finish is $time")
}

// as you can see the current execution of your program is by default TopTOBottom and sequential execution.
suspend fun getmessageAsync() {
    delay(1000)
    println("I am getting message")
}

suspend fun sentMessageAsync() {
    delay(10000)
    println("I am sending message")
}