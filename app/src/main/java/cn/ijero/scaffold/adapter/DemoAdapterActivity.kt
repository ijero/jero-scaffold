package cn.ijero.scaffold.adapter

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import cn.ijero.scaffold.ScaffoldActivity
import cn.ijero.scaffold.databinding.ActivityDemoAdapterBinding
import cn.ijero.scaffold.ext.copyText
import cn.ijero.scaffold.ui.toast

class DemoAdapterActivity : ScaffoldActivity<ActivityDemoAdapterBinding>() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, DemoAdapterActivity::class.java)
            context.startActivity(starter)
        }
    }

    private val viewModel by viewModels<DemoAdapterViewModel>()

    private val mAdapter by lazy {
        DemoAdapter().apply {
            setOnItemClickListener { adapter, view, position ->
                val copyText = data[position].copyText(this@DemoAdapterActivity)
                toast("成功复制内容：%s".format(copyText))
            }
        }
    }

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = mAdapter
    }

    override fun initViewListener() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun initObserver() {
        viewModel.demoData.observe(this) {
            mAdapter.setList(it)
        }
    }

    override fun initData() {
        viewModel.loadData()
    }
}