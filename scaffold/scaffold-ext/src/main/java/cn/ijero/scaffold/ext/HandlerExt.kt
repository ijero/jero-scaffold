package cn.ijero.scaffold.ext

import android.os.Handler
import android.os.Looper

/**
 * 任何地方都可以调用的post方法，支持线程切换和延迟操作的任务执行
 * @param delayMillis 延迟毫秒数，默认为0
 * @param looper lopper轮询器，默认是Looper.getMainLooper()
 * @param runnable 执行任务的Runnable Function对象，在Kotlin中可以用DSL的方式写
 * @param
 * @return
 **/
@JvmOverloads
fun Any.post(
    delayMillis: Long = 0,
    looper: Looper = Looper.getMainLooper(),
    runnable: () -> Unit
) {
    handler(looper).postDelayed(runnable, delayMillis)
}

/**
 * 延时任务，默认延迟1秒，参数与[post]一致
 * @param delayMillis 延迟毫秒数，默认为1000毫秒，即1秒
 * @return
 **/
@JvmOverloads
fun Any.postDelay(
    delayMillis: Long = 1000,
    looper: Looper = Looper.getMainLooper(),
    runnable: () -> Unit
) {
    handler(looper).postDelayed(runnable, delayMillis)
}

@JvmOverloads
fun Any.post(delayMillis: Long = 0, looper: Looper = Looper.getMainLooper(), runnable: Runnable) {
    handler(looper).postDelayed(runnable, delayMillis)
}

@JvmOverloads
fun Any.postDelay(
    delayMillis: Long = 1000,
    looper: Looper = Looper.getMainLooper(),
    runnable: Runnable
) {
    handler(looper).postDelayed(runnable, delayMillis)
}

private fun handler(looper: Looper) = Handler(looper)

