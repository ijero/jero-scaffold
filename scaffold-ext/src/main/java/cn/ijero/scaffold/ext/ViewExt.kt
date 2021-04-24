package cn.ijero.scaffold.ext

import android.view.View
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionManager

/**
 * 是否显示View
 *
 **/
var View.isShow
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

/**
 * 是否隐藏View
 *
 **/
var View.isGone
    get() = visibility != View.VISIBLE
    set(value) {
        visibility = if (value) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

@JvmOverloads
fun View.hideWithTransition(isGone: Boolean = true, transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    if (isGone) {
        this.isGone = true
    } else {
        this.isShow = false
    }
}

@JvmOverloads
fun View.showWithTransition(transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    isShow = true
}

fun View.hideAndEndTransition(isGone: Boolean = true) {
    TransitionManager.endTransitions(parent as ViewGroup)
    if (isGone) {
        this.isGone = true
    } else {
        this.isShow = false
    }
}