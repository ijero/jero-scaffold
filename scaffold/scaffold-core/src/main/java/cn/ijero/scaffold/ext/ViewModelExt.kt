package cn.ijero.scaffold.ext

import androidx.lifecycle.viewModelScope
import cn.ijero.scaffold.ScaffoldViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T : ScaffoldViewModel> T.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(context, start, block)
}

fun <T : ScaffoldViewModel> T.async(block: suspend CoroutineScope.() -> Unit): Job {
    return launch(Dispatchers.IO, CoroutineStart.DEFAULT, block)
}

fun <T : ScaffoldViewModel> T.http(block: suspend CoroutineScope.() -> Unit): Job {
    return async(block)
}

fun <T : ScaffoldViewModel> T.main(block: suspend CoroutineScope.() -> Unit): Job {
    return launch(Dispatchers.Main, CoroutineStart.DEFAULT, block)
}