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

    /**
     *
     * 向 error liveData发送一个错误信息
     *
     **/
    open fun postError(
        throwable: Throwable,
        msg: String? = null,
        errorCode: Int = Error.DEF_ERROR_CODE
    ) {
        postError(Error(throwable, msg, errorCode))
    }

    /**
     *
     * 向 error liveData发送一个错误信息
     *
     **/
    open fun postError(error: Error) {
        _error.postValue(error)
    }

}