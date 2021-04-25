package cn.ijero.scaffold.ext

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.transition.Transition
import androidx.transition.TransitionManager

@JvmOverloads
fun View.hideWithTransition(isGone: Boolean = true, transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    if (isGone) {
        this.isGone = true
    } else {
        this.isVisible = true
    }
}

@JvmOverloads
fun View.showWithTransition(transition: Transition? = null) {
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    isVisible = true
}

fun View.hideAndEndTransition(isGone: Boolean = true) {
    TransitionManager.endTransitions(parent as ViewGroup)
    if (isGone) {
        this.isGone = true
    } else {
        this.isVisible = true
    }
}