package cn.ijero.scaffold.adapter

import cn.ijero.scaffold.ScaffoldAdapter
import cn.ijero.scaffold.databinding.ItemDemoBinding

class DemoAdapter : ScaffoldAdapter<String, ItemDemoBinding>() {

    override fun convert(holder: BaseBindingHolder<ItemDemoBinding>, item: String) {
        holder.viewBinding().apply {

        }
    }

}