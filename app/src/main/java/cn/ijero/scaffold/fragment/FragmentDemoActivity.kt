package cn.ijero.scaffold.fragment

import android.content.Context
import android.content.Intent
import cn.ijero.scaffold.R
import cn.ijero.scaffold.ScaffoldActivity
import cn.ijero.scaffold.databinding.ActivityFragmentDemoBinding

class FragmentDemoActivity : ScaffoldActivity<ActivityFragmentDemoBinding>() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, FragmentDemoActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun initView() {
        val fragment = DemoFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, fragment)
//            .show(fragment)
            .commit()
    }

    override fun initViewListener() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}