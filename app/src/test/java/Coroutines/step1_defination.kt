package Coroutines

/**
 * coroutines are like light co- workers, can communicate to each other ,
 * can run parallel,
 * can wait for each other to finish.
 *
 * but still they are not thread and behave as thread why ?
 *
 * Coroutine can be decomposed into Co and Routine.

A routine in this context is just a sequence of operations/actions and by executing / processing
a routine the sequence of operations gets executed one by one in the exact same order as specified.

Co stands for cooperation. A co routine is asked to (or better expected to)
willingly suspend its execution to give other co-routines a chance to execute too.
So a co-routine is about sharing CPU resources (willingly) so others can use the same resource as oneself is using.

A thread on the other hand does not need to suspend its execution.
Being suspended is completely transparent to the thread and
the thread is forced by underlying hardware to suspend itself.
 * */