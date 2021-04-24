package cn.ijero.scaffold.ext

import android.content.res.Resources
import android.util.TypedValue

val Int.dp: Int
    get() = dp(this.toFloat())

val Float.dp: Int
    get() = dp(this)

val Double.dp: Int
    get() = dp(this.toFloat())

val Int.sp: Int
    get() = sp(this.toFloat())

val Float.sp: Int
    get() = sp(this)

val Double.sp: Int
    get() = sp(this.toFloat())

private fun dp(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        Resources.getSystem().displayMetrics
    ).toInt()
}

private fun sp(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        value,
        Resources.getSystem().displayMetrics
    ).toInt()
}