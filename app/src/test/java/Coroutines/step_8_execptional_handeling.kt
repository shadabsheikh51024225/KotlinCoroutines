package Coroutines

import kotlinx.coroutines.*

/**================================== CANCELLATION EXCEPTION===================================*/

/**  when we cancel any suspend function it throws CancellationException ,
 *   that we can handle using try catch block and maintain the flow of code.
 *
 *
 * */
fun main() = runBlocking {

    println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {

        try {
            for (i in 1..100) {
                println("==$i")
                delay(5)
            }
        }catch (ex:CancellationException)
        {
            println("I have catch the exceptions no worries ")
        }finally {
            println("Finally gonna help me into this...")
        }

    }

    // even after calling cancelable it is not canceling the coroutines,
    // because it is no using any method from KOTLINX.COROUTINE PACKAGE, thats why it is not co-operative.

    delay(10)
    job.cancelAndJoin()
    println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")
}