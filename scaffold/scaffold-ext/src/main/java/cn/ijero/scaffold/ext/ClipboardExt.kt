package cn.ijero.scaffold.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.getSystemService

/**
 *
 * 在上下文中复制文本
 *
 **/
fun Context.copyText(text: CharSequence, label: CharSequence = appName): CharSequence {
    val clipboardManager = getSystemService<ClipboardManager>()
    clipboardManager?.setPrimaryClip(ClipData.newPlainText(label, text))
    return text
}

/**
 *
 * 通过上下文复制文本
 *
 * @return 返回复制内容本身
 **/
fun String.copyText(context: Context, label: CharSequence = context.appName) =
    context.copyText(this, label)

/**
 *
 * 通过上下文复制数字
 *
 **/
fun Number.copyText(context: Context, label: CharSequence = context.appName) =
    context.copyText(this.toString(), label)