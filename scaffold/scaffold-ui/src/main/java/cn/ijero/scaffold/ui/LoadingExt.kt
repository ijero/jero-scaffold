package cn.ijero.scaffold.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView

private var mLoadingPopupView: BasePopupView? = null

// <editor-fold desc="Activity">

fun Context.showLoading(title: CharSequence? = null) {
    if (mLoadingPopupView != null && !mLoadingPopupView!!.isDismiss) {
        return
    }
    if (mLoadingPopupView == null) {
        mLoadingPopupView = XPopup.Builder(this)
            .asLoading(title)
    }
    mLoadingPopupView!!.show()
}

fun Context.showLoading(@StringRes title: Int) {
    showLoading(getString(title))
}

// </editor-fold>

// <editor-fold desc="Fragment">

fun Fragment.showLoading(title: CharSequence? = null) {
    context?.showLoading(title)
}

fun Fragment.showLoading(@StringRes title: Int) {
    context?.showLoading(getString(title))
}

// </editor-fold>
fun hideLoading() {
    mLoadingPopupView?.dismiss()
    mLoadingPopupView = null
}
