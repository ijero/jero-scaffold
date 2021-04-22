package cn.ijero.scaffold

import androidx.activity.viewModels
import cn.ijero.scaffold.databinding.ActivityMainBinding

class MainActivity : ScaffoldActivity() {
    private val binding by viewBinding<ActivityMainBinding>()
    private val viewModel by viewModels<MainViewModel>()

    override fun initView() {
        binding.textView.text = "JeroScaffold1"
    }

}