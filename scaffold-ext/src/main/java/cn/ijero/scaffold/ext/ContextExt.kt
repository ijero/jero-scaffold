package cn.ijero.scaffold.ext

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import cn.ijero.scaffold.util.NavigationBarUtil

val Context.defPref: SharedPreferences
    get() = getSharedPreferences("app_shared_prefs", Context.MODE_PRIVATE)

fun Context.appName(): String {
    return packageManager.getApplicationLabel(applicationInfo).toString()
}

fun Context.appVersionName(): String {
    return packageManager.getPackageInfo(packageName, 0).versionName
}

fun Context.appVersionCode(): Long {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        packageManager.getPackageInfo(packageName, 0).longVersionCode
    } else {
        packageManager.getPackageInfo(packageName, 0).versionCode.toLong()
    }
}

fun Context.navigationBarHeight(): Int {
    return NavigationBarUtil.getNavigationBarHeightIfRoom(this)
}

