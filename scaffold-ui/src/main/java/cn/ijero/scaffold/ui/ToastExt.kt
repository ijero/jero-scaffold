package cn.ijero.scaffold.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

private var mToast: Toast? = null

// <editor-fold desc="Context">

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
    toast(getString(resId))
}

fun Context.longToast(@StringRes resId: Int) {
    toast(getString(resId), true)
}
// </editor-fold>

// <editor-fold desc="Fragment">
fun Fragment.toast(t: Any?) {
    context?.toast(t)
}

fun Fragment.longToast(t: Any?) {
    context?.longToast(t)
}

fun Fragment.toast(@StringRes resId: Int) {
    context?.toast(getString(resId))
}

fun Fragment.longToast(@StringRes resId: Int) {
    context?.toast(getString(resId), true)
}
// </editor-fold>

// <editor-fold desc="View">
fun View.toast(t: Any?) {
    context?.toast(t)
}

fun View.longToast(t: Any?) {
    context?.longToast(t)
}

fun View.toast(@StringRes resId: Int) {
    context?.apply {
        toast(getString(resId))
    }
}

fun View.longToast(@StringRes resId: Int) {
    context?.apply {
        toast(getString(resId), true)
    }
}
// </editor-fold>

// <editor-fold desc="Dialog">
fun Dialog.toast(t: Any?) {
    context.toast(t)
}

fun Dialog.longToast(t: Any?) {
    context.longToast(t)
}

fun Dialog.toast(@StringRes resId: Int) {
    context.apply {
        toast(getString(resId))
    }
}

fun Dialog.longToast(@StringRes resId: Int) {
    context.apply {
        toast(getString(resId), true)
    }
}
// </editor-fold>
