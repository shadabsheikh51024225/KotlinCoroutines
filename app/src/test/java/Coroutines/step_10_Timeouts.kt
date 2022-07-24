package Coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/**================================TIMEOUTS=======================================*/


//in kotlin sometimes you have to cancel a suspend function,
// because it is taking more time to finish.
// also some task are time bounded and usuall gonna take more time to finish the process.
// for that we use timeOuts.


// to deal with such issues we have to main kotlin co-routine builders
//  WithTimeout.
// WithTimeOutOrNull.

fun main() = runBlocking{

    println("I am from main- START and thread name is--- ${Thread.currentThread().name}")

    //the below code is gonna give you some error, because it required more time to execute the code.
    // you can handle exceptions using try  and catch block.

//    withTimeout(2000){
//        for (i in 0..500)
//        {
//            print("$i")
//            delay(500)
//        }
//    }

    /**
     *  we have better option in the form of withTimeOutOrNull().
     *  using that function we can get a return value too.
     *  if function is not able to finish task within given time then we gonna get null.
     *
     *  For EX:-
     *
     * */


   var Result:String? =  withTimeoutOrNull(2000){
        for (i in 0..500)
        {
            println("$i")
            delay(500)
        }
        "Yes we have finished successfully"
    }

    println("I am from main- END and thread name is--- ${Thread.currentThread().name}  and the result is $Result")
}