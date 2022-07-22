package Coroutines

/**
 *   ==========================STRUCTURED CONCURRENCY=================================
 *
 *
 *
 * We can launch coroutines in the specific scope of the operation we are performing.
 * On Android, you can use a scope to cancel all running coroutines when, for example,
 * the user navigates away from an Activity or Fragment.

    To start a coroutine, we would need to create a scope like so:
 *
 *  class MainViewModel : ViewModel(){
    private lateinit var job: Job
    private lateinit var coroutineScope: CoroutineScope
    private fun initialize(){
    // create job & scope
    job = Job()
    coroutineScope = CoroutineScope(Dispatchers.Main + job)
    }
    }
 *
 *
 * */


/**
 * ===========================Dispatchers===============================*/

/**
 *  dispatcher controls which thread runs a coroutine. Some dispatchers include:

Dipatchers.Default: The default dispatcher used by coroutine builders (e.g., async, launch) if no dispatcher was specified.

Dispatchers.Main: This dispatcher is confined to the main thread, so if you’d like to update the UI thread, use this.

Dispatchers.IO: This dispatcher can be used when we want to perform blocking IO tasks
on another thread so that we don’t free or possibly crash the app.


In the code snippet above, the coroutineScope will be started in the main thread
(we know this because we specified that the dispatcher should be Dispatchers.Main).

If you’re wondering what the point is and why we’d want to start a coroutine on the main thread,
that’s fine. However, know that the coroutine will not block the main thread while it’s suspended. I explained how it would work here.

Canceling​ this coroutine is very easy because we only have to do it once.

We may want to cancel once the view model is no longer used (when the activity or fragment using the model is no longer active).
 * */


/**
 * Once we cancel the job, all the coroutines launched by coroutineScope will be canceled as well.
 * Canceling jobs helps us prevent coroutine leaks.
 * */