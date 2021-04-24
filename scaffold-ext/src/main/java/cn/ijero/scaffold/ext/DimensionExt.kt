package cn.ijero.scaffold.ext

import android.content.res.Resources
import android.util.TypedValue

val Int.dpInt: Int
    get() = dp(this.toFloat()).toInt()

val Float.dpInt: Int
    get() = dp(this).toInt()

val Double.dpInt: Int
    get() = dp(this.toFloat()).toInt()

val Int.spInt: Int
    get() = sp(this.toFloat()).toInt()

val Float.spInt: Int
    get() = sp(this).toInt()

val Double.spInt: Int
    get() = sp(this.toFloat()).toInt()

val Int.dp: Float
    get() = dp(this.toFloat())

val Float.dp: Float
    get() = dp(this)

val Double.dp: Float
    get() = dp(this.toFloat())

val Int.sp: Float
    get() = sp(this.toFloat())

val Float.sp: Float
    get() = sp(this)

val Double.sp: Float
    get() = sp(this.toFloat())

private fun dp(value: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        Resources.getSystem().displayMetrics
    )
}

private fun sp(value: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        value,
        Resources.getSystem().displayMetrics
    )
}