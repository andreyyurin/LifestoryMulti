package ru.sad.lifestorymulti.base

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import org.koin.mp.KoinPlatformTools
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S, DS, E, A> : ViewModel(), CoroutineScope {

    val state: SharedFlow<S> by lazy { stateFlow }

    val dialogState: SharedFlow<DS> by lazy { dialogStateFlow }

    val action: SharedFlow<A> by lazy { actionFlow }

    private val stateFlow =
        MutableSharedFlow<S>(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val dialogStateFlow =
        MutableSharedFlow<DS>(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val actionFlow = MutableSharedFlow<A>(
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        extraBufferCapacity = 1
    )

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        handleError(exception)
    }

    override val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    abstract fun onEvent(event: E)

    protected fun setState(state: S) = stateFlow.tryEmit(state)

    protected fun getStateValueOrNull() = state.replayCache.firstOrNull()

    protected fun setDialogState(dialogState: DS) = dialogStateFlow.tryEmit(dialogState)

    protected fun emitAction(action: A) = actionFlow.tryEmit(action)

    private fun handleError(throwable: Throwable) {

    }

    open fun CoroutineScope.launchIO(
        exception: suspend (String) -> Unit = {},
        r: suspend () -> Unit
    ) {
        launch(Dispatchers.IO) {
            try {
                r.invoke()
            } catch (e: Exception) {
                e.message?.let { exception.invoke(it) }
            }
        }
    }

    open fun CoroutineScope.launchPeriodicAsync(repeatMillis: Long, action: suspend () -> Unit) {
        launch(Dispatchers.IO) {
            while (isActive) {
                action.invoke()
                delay(repeatMillis)
            }
        }
    }

    inline fun <reified T: Any> lazyRepository(): T {
        return KoinPlatformTools.defaultContext().get().get()
    }
}