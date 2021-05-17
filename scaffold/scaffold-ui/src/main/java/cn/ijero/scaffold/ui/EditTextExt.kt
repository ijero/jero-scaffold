package cn.ijero.scaffold.ui

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat

/**
 *
 * 显示软键盘
 *
 **/
fun EditText.showInput() {
    val imm = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    imm?.showSoftInput(this, 0)
}

/**
 *
 * 隐藏软键盘
 *
 **/
fun EditText.hideInput() {
    val imm = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    imm?.hideSoftInputFromWindow(windowToken, 0)
}