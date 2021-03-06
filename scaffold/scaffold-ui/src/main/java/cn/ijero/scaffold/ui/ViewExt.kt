package cn.ijero.scaffold.ui

import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.transition.Transition
import androidx.transition.TransitionManager

@JvmOverloads
fun View.hideWithTransition(
    isGone: Boolean = true,
    transition: Transition? = null,
    parent: ViewGroup = this.parent as ViewGroup
) {
    TransitionManager.beginDelayedTransition(parent, transition)
    if (isGone) {
        this.isGone = true
    } else {
        this.isVisible = true
    }
}

@JvmOverloads
fun View.showWithTransition(
    transition: Transition? = null,
    parent: ViewGroup = this.parent as ViewGroup
) {
    TransitionManager.beginDelayedTransition(parent, transition)
    isVisible = true
}

fun View.hideAndEndTransition(
    isGone: Boolean = true,
    parent: ViewGroup = this.parent as ViewGroup
) {
    TransitionManager.endTransitions(parent)
    if (isGone) {
        this.isGone = true
    } else {
        this.isVisible = true
    }
}

class OnSingleClickListener(private val block: (View) -> Unit) : View.OnClickListener {
    private var lastClickTime = 0L
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) {
            return
        }
        lastClickTime = SystemClock.elapsedRealtime()
        block(v)
    }
}

fun View.setOnSingleClickListener(block: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener(block))
}