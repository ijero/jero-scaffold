package cn.ijero.scaffold.adapter

import cn.ijero.scaffold.databinding.ItemDemoBinding
import cn.ijero.scaffold.ui.adapter.ScaffoldAdapter

class DemoAdapter : ScaffoldAdapter<String, ItemDemoBinding>() {

    override fun convert(holder: BaseBindingHolder<ItemDemoBinding>, item: String) {
        holder.viewBinding().apply {

        }
    }

}