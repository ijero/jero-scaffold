package cn.ijero.scaffold

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.inflateBindingWithGeneric

abstract class ScaffoldFragment<VB : ViewBinding> : Fragment() {

    // <editor-fold desc="成员变量">
    private var _binding: VB? = null
    protected open val binding: VB
        get() = _binding!!
    // </editor-fold>

    // <editor-fold desc="内部函数">
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateBindingWithGeneric(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewBefore(savedInstanceState)
        initView()
        initViewListener()
        initObserver()
        initData()
    }
    // </editor-fold>


    // <editor-fold desc="初始化方法">
    /**
     * 初始化View，建议在此方法中进行初始化View状态，设置默认显示值等
     *
     * @author WangChun
     */
    protected open fun initView() {}

    /**
     * 初始化View监听器，在[initView]之后调用，建议在此方法中进行View的监听器设置
     *
     * @author WangChun
     */
    protected open fun initViewListener() {}

    /**
     * 初始化观察者，建议在此方法中进行观察viewModel中的数据
     *
     * @author WangChun
     */
    protected open fun initObserver() {}

    /**
     * 初始化数据，建议在此方法中进行该界面的第一次数据加载
     *
     * @param
     * @return
     * @author WangChun
     */
    protected open fun initData() {}

    /**
     * 在初始化View之前调用，可以进行一些数据预处理，
     * 如：从intent中读取数据，通过[savedInstanceState]获取保存状态等
     *
     * @param savedInstanceState 参考[android.app.Activity#onCreate]
     * @author WangChun
     */
    protected open fun initViewBefore(savedInstanceState: Bundle?) {}
    // </editor-fold>


}