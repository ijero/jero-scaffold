package cn.ijero.scaffold

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _randomInt = MutableLiveData<Int>()
    val randomInt: LiveData<Int> = _randomInt


    fun randomInt(){
        viewModelScope.launch {
            _randomInt.postValue(Random.nextInt())
        }
    }
}