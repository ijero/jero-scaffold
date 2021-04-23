package cn.ijero.scaffold.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.ijero.scaffold.R
import kotlin.random.Random

class DemoFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val _randomFood = MutableLiveData<String>()
    val randomFood: LiveData<String> = _randomFood

    fun randomFood() {
        val foods =
            getApplication<Application>().getString(R.string.food).split(",").map { it.trim() }
        _randomFood.postValue(foods[Random.nextInt(0, foods.size)])
    }
}