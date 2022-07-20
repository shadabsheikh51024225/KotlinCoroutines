package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  ==================Thread.sleep  vs  delay=========================
 *
 *
 *
 *  when you make any thread sleep it will block the entire thread and will make system wait,
 *  on other hand when you delay a co-routine it will just delay a background thread and
 *  not even disturb other concurrently running other coroutines.
 *
 * */

fun main() {
    Thread.sleep(5000)
    println("the thread name is -- ${Thread.currentThread().name} -- i am first ")
    println("the thread name is -- ${Thread.currentThread().name} --- i am second")
     coroutine_thread()
    Thread.sleep(2000)
}

fun coroutine_thread() {
    GlobalScope.launch {
        println("the thread name is--${Thread.currentThread().name} ---i am c0-fist")
        delay(1000)
        println("the thread name is --${Thread.currentThread().name}---- i c0-am second")
    }
}
