package cn.ijero.scaffold.ui

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

/**
 * 清空输入框内容
 *
 */
fun TextView.clearText() {
    if (this is EditText) {
        setText("", TextView.BufferType.EDITABLE)
    } else {
        setText("", TextView.BufferType.NORMAL)
    }
}
