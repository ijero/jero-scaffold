package cn.ijero.scaffold

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

open class ScaffoldViewModel(application: Application) : AndroidViewModel(application) {
    open val context: Context
        get() = getApplication()

}