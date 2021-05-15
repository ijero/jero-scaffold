package cn.ijero.scaffold

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.ijero.scaffold.data.Error

open class ScaffoldViewModel(application: Application) : AndroidViewModel(application) {
    open val context: Context
        get() = getApplication()

    private val _error = MutableLiveData<Error>()
    val error: LiveData<Error> = _error

    protected open fun postError(throwable: Throwable, msg: String? = null) {
        _error.postValue(Error(throwable, msg))
    }

}