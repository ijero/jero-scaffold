package cn.ijero.scaffold.ext

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

private var mToast: Toast? = null

@SuppressLint("ShowToast")
@JvmOverloads
fun Context.toast(t: Any?, isLong: Boolean = false) {
    val duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    if (mToast != null) {
        mToast!!.cancel()
    }
    mToast = Toast.makeText(this, t.toString(), duration)
    mToast?.show()
}

fun Context.longToast(t: Any?) {
    toast(t, true)
}

fun Context.toast(@StringRes resId: Int) {
    toast(getString(resId), false)
}

fun Context.longToast(resId: Int) {
    toast(getString(resId), true)
}

fun Fragment.toast(t: Any?) {
    context?.toast(t, false)
}

fun Fragment.longToast(t: Any?) {
    context?.longToast(t)
}