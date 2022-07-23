package Coroutines

import kotlinx.coroutines.*


/**==============================COROUTINE SCOPE========================================*/

    /**
     * each coroutine scope comes with a boolean flag value,
     * this value tells us that coroutine is active or not
     *
     * CoRoutineScope.isActive boolean flag so that
     * we can get to know which coroutine is active and cancelable.
     *
     * =============threads dont have any flag to share details about active and inactive state,
     * that's another advantages with coroutines.===========
     * */

    fun main() = runBlocking{

        println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")

        val job: Job = launch(Dispatchers.Default) {  for (i in 1..100)
        {
            println("==$i")
            if(isActive)// checking the current coroutine is active or not.
            {
                println("I AM ACTIVE")// perform actions according to results.
            }
            if(!isActive)
            {break}

        }}

        // even after calling cancelable it is not canceling the coroutines,
        // because it is no using any method from KOTLINX.COROUTINE PACKAGE, thats why it is not co-operative.

        delay(100)
        job.cancelAndJoin()
        println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")




    }
