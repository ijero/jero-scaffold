package cn.ijero.scaffold.ext

import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService

fun Activity.handleInput(event: MotionEvent): Boolean {
    if (event.action == MotionEvent.ACTION_DOWN) {
        val v = currentFocus
        if (isShouldHideInput(v, event)) {
            if (hideInputMethod(this, v)) {
                v?.clearFocus()
                return true //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
            }
        }
    }
    return false
}

private fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
    if (v != null && v is EditText) {
        val leftTop = intArrayOf(0, 0)
        v.getLocationInWindow(leftTop)
        val left = leftTop[0]
        val top = leftTop[1]
        val bottom = top + v.height
        val right = (left
                + v.width)
        return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
    }
    return false
}

private fun hideInputMethod(context: Context, v: View?): Boolean {
    val imm: InputMethodManager = context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return imm.hideSoftInputFromWindow(v?.windowToken, 0)
}

fun EditText.showInput() {
    val imm = getSystemService(context, InputMethodManager::class.java)
    imm?.showSoftInput(this, 0)
}

fun EditText.hideInput() {
    val imm = getSystemService(context, InputMethodManager::class.java)
    imm?.hideSoftInputFromWindow(windowToken, 0)
}