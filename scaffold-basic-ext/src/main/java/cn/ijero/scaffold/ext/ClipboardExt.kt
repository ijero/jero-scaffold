package cn.ijero.scaffold.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.getSystemService

fun Context.copyPlainText(text: CharSequence, label: CharSequence = appName) {
    val clipboardManager = getSystemService<ClipboardManager>()
    clipboardManager?.setPrimaryClip(ClipData.newPlainText(label, text))
}

fun String.copyPlainText(context: Context, label: CharSequence = context.appName) {
    val clipboardManager = context.getSystemService<ClipboardManager>()
    clipboardManager?.setPrimaryClip(ClipData.newPlainText(label, this))
}

fun Int.copyPlainText(context: Context, label: CharSequence = context.appName) {
    this.toString().copyPlainText(context, label)
}

fun Float.copyPlainText(context: Context, label: CharSequence = context.appName) {
    this.toString().copyPlainText(context, label)
}

fun Double.copyPlainText(context: Context, label: CharSequence = context.appName) {
    this.toString().copyPlainText(context, label)
}
