package cn.ijero.scaffold

import android.view.View
import androidx.activity.viewModels
import cn.ijero.scaffold.databinding.ActivityMainBinding
import cn.ijero.scaffold.fragment.FragmentDemoActivity

class MainActivity : ScaffoldActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override fun initView() {
        binding.textView.text = "JeroScaffold1"
    }

    override fun initObserver() {
        viewModel.randomInt.observe(this) {
            binding.textView.text = "$it"
        }
    }

    fun random(view: View) {
        viewModel.randomInt()
    }

    fun toFragment(view: View) {
        FragmentDemoActivity.start(this)
    }

}