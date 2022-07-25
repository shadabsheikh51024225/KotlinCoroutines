package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * EACH COROUTINE BUILDER HAS ITS OWN SCOPE AND IT DOESN'T MATTER IT IS A CHILD COROUTINE OR
 * PARENT COROUTINE, EACH OF THEM HAVE THEIR OWN COROUTINE SCOPE.
 *
 * WE CAN GET COROUTINE SCOPE USING THIS KEYWORD.
 *
 * BUILDERS ARE JUST TO BUILD COROUTINES AND SCOPE IT SOMETHING WHICH WILL ACTUALLY PROVIDE,
 * CONTEXT TO COROUTINES.
 * */

suspend fun main()  = runBlocking {


    GlobalScope.launch {
        println("i am from LAUNCH ${this}")

        GlobalScope.launch {
            println("i am from LAUNCH- CHILD ${this}")
        }
    }
    GlobalScope.async {
        println("i am from ASYNC ${this}")
    }

}.await()