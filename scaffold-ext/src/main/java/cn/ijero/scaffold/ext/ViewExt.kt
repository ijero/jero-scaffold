package cn.ijero.scaffold.ext

import android.view.View
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionManager

/**
 * 隐藏View
 * @param isGone true时使用 [View.GONE]方式隐藏，false时使用[View.INVISIBLE]方式隐藏
 * @return
 **/
@JvmOverloads
fun View.hide(isGone: Boolean = true) {
    visibility = if (isGone) {
        View.GONE
    } else {
        View.INVISIBLE
    }
}

/**
 * 显示View
 * @return
 **/
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * View是否在显示
 *
 **/
fun View.isShow() = visibility == View.VISIBLE

/**
 * View是否已隐藏
 *
 **/
fun View.isHide() = visibility != View.VISIBLE

@JvmOverloads
fun View.hideWithTransition(isGone: Boolean = true, transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    hide(isGone)
}

@JvmOverloads
fun View.showWithTransition(transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    show()
}

fun View.hideAndEndTransition(){
    TransitionManager.endTransitions(parent as ViewGroup)
    hide()
}