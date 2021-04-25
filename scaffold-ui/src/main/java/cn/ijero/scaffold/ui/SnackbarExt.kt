package cn.ijero.scaffold.ext

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun String.snackbar(
    view: View,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    view.snackbar(this, duration)
}

fun View.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(this, text, duration).show()
}

fun View.snackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(context.getString(resId), duration)
}

fun Activity.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    findViewById<View>(android.R.id.content).snackbar(text, duration)
}

fun Activity.snackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(resId), duration)
}

fun Fragment.snackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    view?.snackbar(text, duration)
}

fun Fragment.snackbar(
    @StringRes resId: Int,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(resId), duration)
}