package Coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Co- routines are co-operative once you use any suspend function (Like , delay(), yield(), withContext etc),
 * if method belongs to KOTLINX.COROUTINE PACKAGE,
 * it will make them cooperative automatically.
 * and only CO-OPERATIVE COROUTINES CAN CALL CANCLE().
 * */



fun main() = runBlocking{

    println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")

    val job:Job = launch {  for (i in 1..100)
    {
        println("==$i")
        Thread.sleep(50)
    }}

    // even after calling cancelable it is not canceling the coroutines,
    // because it is no using any method from KOTLINX.COROUTINE PACKAGE, thats why it is not co-operative.

    job.cancel()
    job.join()
    println("I AM FROM MAIN AND THREAD NAME IS == ${Thread.currentThread().name}")




}