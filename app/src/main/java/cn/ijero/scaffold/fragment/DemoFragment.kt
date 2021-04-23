package cn.ijero.scaffold.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import cn.ijero.scaffold.R
import cn.ijero.scaffold.ScaffoldFragment
import cn.ijero.scaffold.databinding.FragmentDemoBinding

class DemoFragment : ScaffoldFragment<FragmentDemoBinding>() {

    companion object {
        fun newInstance(): DemoFragment {
            val args = Bundle()

            val fragment = DemoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val viewModel by viewModels<DemoFragmentViewModel>()

    override fun initObserver() {
        viewModel.randomFood.observe(this) {
            binding.textView.text = getString(R.string.format_i_like_eat, it)
        }
    }

    override fun initViewListener() {
        binding.button.setOnClickListener {
            viewModel.randomFood()
        }
    }
}