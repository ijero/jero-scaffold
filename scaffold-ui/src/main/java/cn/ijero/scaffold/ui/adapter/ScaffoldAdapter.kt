package cn.ijero.scaffold.ui.adapter

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.dylanc.viewbinding.base.inflateBindingWithGeneric

abstract class ScaffoldAdapter<T, VB : ViewBinding>(layoutResId: Int = -1) :
    BaseQuickAdapter<T, ScaffoldAdapter.BaseBindingHolder<VB>>(layoutResId) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int) =
        BaseBindingHolder<VB>(inflateBindingWithGeneric<VB>(parent))

    class BaseBindingHolder<VB : ViewBinding>(
        private val binding: ViewBinding
    ) : BaseViewHolder(binding.root) {
        @Suppress("UNCHECKED_CAST")
        fun viewBinding() = binding as VB
    }

}