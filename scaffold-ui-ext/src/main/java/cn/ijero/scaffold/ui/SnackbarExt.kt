package cn.ijero.scaffold.ui

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

// <editor-fold desc="View扩展">
fun View.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(this, text, duration).show()
}

fun View.longSnackbar(
    text: String
) {
    snackbar(text, Snackbar.LENGTH_LONG)
}

fun View.snackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(context.getString(resId), duration)
}

fun View.longSnackbar(
    @StringRes resId: Int,
) {
    snackbar(context.getString(resId), Snackbar.LENGTH_LONG)
}

// </editor-fold>

// <editor-fold desc="String扩展">
fun String.snackbar(
    view: View,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    view.snackbar(this, duration)
}

fun String.longSnackbar(
    view: View
) {
    snackbar(view, Snackbar.LENGTH_LONG)
}

// </editor-fold>

// <editor-fold desc="Activity扩展">

fun Activity.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    findViewById<View>(android.R.id.content).snackbar(text, duration)
}

fun Activity.longSnackbar(
    text: String
) {
    snackbar(text, Snackbar.LENGTH_LONG)
}

fun Activity.snackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(resId), duration)
}

fun Activity.longSnackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(resId), Snackbar.LENGTH_LONG)
}

// </editor-fold>

// <editor-fold desc="Fragment扩展">
fun Fragment.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    view?.snackbar(text, duration)
}

fun Fragment.longSnackbar(
    @StringRes resId: Int,
) {
    snackbar(getString(resId), Snackbar.LENGTH_LONG)
}
// </editor-fold>