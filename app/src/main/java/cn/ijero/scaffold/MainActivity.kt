package cn.ijero.scaffold

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import cn.ijero.scaffold.databinding.ActivityMainBinding

class MainActivity : ScaffoldActivity() {
    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}