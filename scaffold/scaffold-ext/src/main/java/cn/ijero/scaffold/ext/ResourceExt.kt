package cn.ijero.scaffold.ext

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.annotation.RawRes

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
