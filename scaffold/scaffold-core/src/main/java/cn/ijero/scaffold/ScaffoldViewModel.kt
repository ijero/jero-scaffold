package cn.ijero.scaffold

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.ijero.scaffold.data.ErrorData

open class ScaffoldViewModel(application: Application) : AndroidViewModel(application) {
    open val context: Context
        get() = getApplication()

    private val _error = MutableLiveData<ErrorData>()
    val error: LiveData<ErrorData> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    /**
     *
     * 向 error liveData发送一个错误信息
     *
     **/
    open fun postError(
        error: Throwable? = null,
        msg: String? = null,
        errorCode: Int = ErrorData.DEF_ERROR_CODE
    ) {
        postError(ErrorData(error, msg, errorCode))
    }

    /**
     *
     * 向 error liveData发送一个错误信息
     *
     **/
    open fun postError(error: ErrorData) {
        _error.postValue(error)
    }

    /**
     *
     * 提交一个loading信息
     *
     * @param isLoading true 表示正在加载数据，false 表示结束加载数据
     *
     **/
    open fun postLoading(isLoading: Boolean) {
        _loading.postValue(isLoading)
    }
}