package cn.ijero.scaffold.ext

import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService

/**
 *
 * 自动隐藏EditText正在占用的软键盘
 *
 * 复写[Activity.dispatchTouchEvent]函数，并调用该扩展，例：
 *
 * ```
 *  override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
 *      return autoHideInput(ev) || super.dispatchTouchEvent(ev)
 *  }
 * ```
 *
 * @param event [Activity.dispatchTouchEvent]方法参数的[MotionEvent]对象
 * @param viewResponse `true`-在成功隐藏软键盘后将事件继续传递给正在点击的view，`false`-则不传递
 *
 **/
fun Activity.autoHideInput(event: MotionEvent, viewResponse: Boolean = false): Boolean {
    if (event.action == MotionEvent.ACTION_DOWN) {
        val v = currentFocus
        if (isShouldHideInput(v, event)) {
            if (hideInputMethod(this, v)) {
                v?.clearFocus()
                return viewResponse
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

/**
 *
 * 显示软键盘
 *
 **/
fun EditText.showInput() {
    val imm = getSystemService(context, InputMethodManager::class.java)
    imm?.showSoftInput(this, 0)
}

/**
 *
 * 隐藏软键盘
 *
 **/
fun EditText.hideInput() {
    val imm = getSystemService(context, InputMethodManager::class.java)
    imm?.hideSoftInputFromWindow(windowToken, 0)
}