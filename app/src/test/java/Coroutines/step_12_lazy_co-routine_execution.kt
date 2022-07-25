package Coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking {

    println("I am from main- START and thread name is--- ${Thread.currentThread().name}")

  //LAZY EXECUTES THE CODE WHEN IT IS REQUIRED
    // IN KOTLIN IF SOMETHING IS LAZY MEANS IT IS SMART.
    // WITHOUT LAZY , THE PROGRAM WILL RUN SUSPEND FUNCTION AND HOLD RESOURCES SOME HOW,
    // BUT WE DON'T NEED ANYTHING FORM THEM NOW SO USING LAZY IS JUST LIKE WAITING AS LONG AS THEY DON'T CALL YOUR NAME.



        var getm:Deferred<Int> = async (start = CoroutineStart.LAZY){getmessageA()}
        var gets:Deferred<Int> = async (start = CoroutineStart.LAZY){sentMessageA()}

    println(" i am from getm ${getm.await()} and i am from gets ${gets.await()}")
//Awaits for completion of this value without blocking a thread
// and resumes when deferred computation is complete,
// returning the resulting value or throwing the corresponding exception if the deferred was cancelled.
//This suspending function is cancellable.
// If the Job of the current coroutine is cancelled or completed while this suspending function is waiting,

    println("I am from main- END and thread name is--- ${Thread.currentThread().name} time taken to finish is ")
}

// as you can see the current execution of your program is by default TopTOBottom and sequential execution.
suspend fun getmessageA(): Int {
    delay(1000)
   return 1
}

suspend fun sentMessageA():Int {
    delay(10000)
    return 2
}