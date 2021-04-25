package cn.ijero.scaffold.ext

import android.util.Log

inline val <T : Any>  T.TAG: String
    get() = this.javaClass.simpleName

fun <T : Any> T.loge(
        msg: String,
        throwable: Throwable? = null,
        tag: String? = TAG
) {
    Log.e(tag, msg, throwable)
}

fun <T : Any> T.logd(
        msg: String,
        throwable: Throwable? = null,
        tag: String? = TAG
) {
    Log.d(tag, msg, throwable)
}

fun <T : Any> T.logv(
        msg: String,
        throwable: Throwable? = null,
        tag: String? = TAG
) {
    Log.v(tag, msg, throwable)
}

fun <T : Any> T.logi(
        msg: String,
        throwable: Throwable? = null,
        tag: String? = TAG
) {
    Log.i(tag, msg, throwable)
}

fun <T : Any> T.logw(
        msg: String,
        throwable: Throwable? = null,
        tag: String? = TAG
) {
    Log.w(tag, msg, throwable)
}



