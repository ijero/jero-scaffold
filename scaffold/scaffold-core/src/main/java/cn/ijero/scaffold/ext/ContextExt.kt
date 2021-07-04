package cn.ijero.scaffold.ext

import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build

val Context.defPref: SharedPreferences
    get() = getSharedPreferences("app_shared_prefs", Context.MODE_PRIVATE)

val Context.appName: String
    get() = packageManager.getApplicationLabel(applicationInfo).toString()

val Context.appVersionName: String
    get() = packageManager.getPackageInfo(packageName, 0).versionName

val Context.appVersionCode: Long
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        packageManager.getPackageInfo(packageName, 0).longVersionCode
    } else {
        packageManager.getPackageInfo(packageName, 0).versionCode.toLong()
    }

val Context.navigationBarHeight: Int
    get() = navigationBarHeightIfRoom()

fun Context.resourceToUri(resId: Int): String {
    val r = resources
    val uri = Uri.parse(
        ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(resId) + "/"
                + r.getResourceTypeName(resId) + "/"
                + r.getResourceEntryName(resId)
    )
    return uri.toString()
}
