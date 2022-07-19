package Coroutines

/** when any application launches, it launched in main thread.
 * and main thread is designed to deal with small tasks like Ui rendering, button clicks,small calculation expressions.
 *
 *
 * if we run heavy task like , connection request, uploading a image or downloading one , then it
 * will crash application because it will take time to process and hold the main thread for
 * long time.
 *
 *
 * to overcome this situation we have back ground thread for each task and,
 * then we can easily execute multiple components background. like async tasks.
 *
 *
 * but still suppose we have 20 things to do in background thread and suppose we create,
 * 20 background thread, then each thread it taking a samll amount of memory and hard to manage priority at run time,
 * so finally application crashed.
 *
 *
 *  ==== HERE COMES COROUTINES TO SAVE US ======
 *
 *  CREAET ONE BACKGROUND THREAD AND START AS MANY COROUTINE WORKS AS MUCH AS POSSIBLE...
 *
 *
 *  HOW? WELL LOOK AT EXAMPLES LOL ,,,,,,
 *
 *
 *
 *
 * */