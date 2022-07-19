package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main()
{

    //RUN THE PROGRAM AND CHECK THE THREAD NAME AND THEIR SEQUANCE OF EXECUTION. 

    // ALWAYS MAIN THREAD.
    from_main()

    //THIS IS TRADITIONAL THREAD WAY TO LAUNCH THE THREAD.
    thread {
        //MAIN THREAD WILL ALWAYS WAIT FOR BACKGROUND THREAD TO  FINISH BUT NEVER CARE ABOUT
        //KOTLIN COROUTINES TO FINISH
        // THAT'S WHY WE ARE MAKING THIS THREAD TO WAIT FOR 2 SECONDS TO FINISH ,
        // SO THAT COROUTINES WILL HAVE SOME TIME TO FINISH THEIR TASKS,
        //HENCE PROVED THEY ARE NOT ANY BACKGROUND THREADS.
        Thread.sleep(2000)
        // THIS ONE IS BACKGROUND THREAD-0
        from_thread_start()
        from_thread_finish()
    }

    // THIS WAY YOU PROVIDE COROUTINE SCOPE TO RUN A WORKER TASK.
    // THIS THREAD IS GONNA LAUNCH FROM DEFAULT DISPATCHERS THREAD
    GlobalScope.launch {
        from_co_start()
        from_co_finish()

    }

}

fun from_thread_start()
{
    println("THREAD NAME : - ${Thread.currentThread().name} ======= i am from thread start")
}

fun from_thread_finish()
{
    println("THREAD NAME : - ${Thread.currentThread().name} ======= i am from thread finish")
}

fun from_co_start()
{
    println("THREAD NAME : - ${Thread.currentThread().name} ======= i am from co-start")
}

fun from_co_finish()
{
    println("THREAD NAME : - ${Thread.currentThread().name} ======= i am from co-finish")
}

fun from_main()
{
    println("THREAD NAME : - ${Thread.currentThread().name} ======= i am from main")
}