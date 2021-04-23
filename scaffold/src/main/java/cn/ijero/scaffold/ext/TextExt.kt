package cn.ijero.scaffold.ext

import android.widget.EditText
import android.widget.TextView

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
