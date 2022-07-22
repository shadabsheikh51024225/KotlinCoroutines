package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * ====================== SUSPEND FUNCTIONS ======================
 *
 * Suspending functions are at the center of everything coroutines.
 * A suspending function is simply a function that can be paused and resumed at a later time.
 * They can execute a long running operation and wait for it to complete without blocking.
 *
 * One of the most important points to remember about the suspend functions is that
 * they are only allowed to be called from a coroutine or another suspend function.
 *
 * */

fun main(){

    println("I AM IN THE ====  ${Thread.currentThread().name}  === i am start")

    GlobalScope.launch {

        println("I AM IN THE ====  ${Thread.currentThread().name}  === i am c0-start")
        delay(2000)
        println("I AM IN THE ====  ${Thread.currentThread().name}  === i am c0-end")
    }

    /**
     * Runs a new coroutine and blocks the current thread interruptibly until its completion.
     * This function should not be used from a coroutine.
     * It is designed to bridge regular blocking code to libraries that are written in suspending style,
     * to be used in main functions and in tests.
     * */
    runBlocking {
        //WE CAN NOT CALL DELAY FUNCTION OUTSIDE BECAUSE IT IS A SUSPEND FUNCTION SO TO CALL IT FROM OUTSIDE WE NEED
        //TO WRAP IT AROUND RUN BLOCKING.
        delay(2000)
    }


    //JUST REMEMBER ONE THING globalscope.launch is not blocking the main thread , where run blocking is blocking main thread

}