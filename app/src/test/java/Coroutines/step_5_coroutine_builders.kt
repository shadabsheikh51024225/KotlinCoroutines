package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Coroutine builders are functions that help us create a coroutine.
 * They can be called from normal functions because they do not suspend themselves.
 *
 * ====================Three coroutine builders are listed below.=============================

launch: start a coroutine in the background and keep working./ this will use JOb object to finish the task.

async: perform an asynchronous operation and return a deferred object which is the equivalent of a JavaScript promise.
We can call await on the deferred value in order to wait and get the result./ this will give us deferred object, which is kind of generic type.

runBlocking: this blocks the current thread and waits for the coroutine to finish execution.(Mainly used to test suspend functions).
 *
 * */


/** =========================================Launching Coroutines==================================*/

/**
 * Coroutines are launched in coroutine builders and are bound by a coroutine scope.
 * A lazy way to launch a coroutine would be to use the GlobalScope.
 * This means that the coroutine would be running for as long as the APPLICATION is running and,
 * if there is no important reason to do this, I believe that it’s a way to wrongly use resources.
 *
 *
 * we don’t want to launch coroutines in the GlobalScope.
 * When launching a coroutine, we want to be sure that we do it right so that
 * we can avoid coroutine leaks that will cause us to run out of memory.

In my opinion, launching coroutines in GlobalScope,
and forgetting to keep a reference so that we can manually cancel later,
could be as error-prone as using callbacks. How do we solve this problem?
That’s where structured concurrency comes in.
 * */

fun GlobalScopeDef()
{
}

fun main(){

    println("I am from Main and my thread name is:-${Thread.currentThread().name}")

    runBlocking {

        //No need to use global scope because its already inside run blocking.
       var Job:Job =  launch{

            // thread name of launch is also same as main print because it is inheriting the scope of parent thread.
            println("I am from Launch and my thread name is:-${Thread.currentThread().name}")
        }

        // join is use to let existing coroutine to finish the job , better than delay ,
        //because we dont need to mentioned time for work to finish , that we dont know anyway.
        Job.join()

        //this is just to cancel the coroutine and to kill it.
        Job.cancel()
    }

}

