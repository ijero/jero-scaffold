package cn.ijero.scaffold.adapter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.ijero.scaffold.ScaffoldViewModel

class DemoAdapterViewModel(application: Application) : ScaffoldViewModel(application) {

    private val _demoData = MutableLiveData<MutableList<String>>()
    val demoData: LiveData<MutableList<String>> = _demoData

    fun loadData(){
        val data = mutableListOf(
            "哈哈哈",
            "嘿嘿嘿",
            "嘻嘻嘻",
            "快速开发脚手架",
            "关注Jero",
            "点击下面连接复制后去浏览器打开",
            "https://gitee.com/ijero/jero-scaffold",
            "蟹蟹支持，么么哒~~"
        )
        _demoData.postValue(data)
    }
}