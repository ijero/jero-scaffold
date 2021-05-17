package cn.ijero.scaffold.ext

import android.content.res.Resources
import android.util.TypedValue

val Number.dpInt: Int
    get() = dp(this.toFloat()).toInt()

val Number.spInt: Int
    get() = sp(this.toFloat()).toInt()

val Number.dp: Float
    get() = dp(this.toFloat())

val Number.sp: Float
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