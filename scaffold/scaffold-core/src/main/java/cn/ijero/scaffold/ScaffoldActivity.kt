package cn.ijero.scaffold

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.ijero.scaffold.util.autoHideInput
import com.dylanc.viewbinding.base.inflateBindingWithGeneric

abstract class ScaffoldActivity<VB : ViewBinding> : AppCompatActivity() {

    // <editor-fold desc="成员变量">
    protected open lateinit var binding: VB

    /**
     *
     * 是否启用自动隐藏软键盘功能
     *
     **/
    protected open var isAutoHideInput = true
    // </editor-fold>

    // <editor-fold desc="内部函数">
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBefore(savedInstanceState)

        binding = inflateBindingWithGeneric(layoutInflater)
        setContentView(binding.root)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        initView()
        initViewListener()
        initObserver()
        initData()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return (isAutoHideInput && autoHideInput(ev)) || super.dispatchTouchEvent(ev)
    }

    // </editor-fold>

    // <editor-fold desc="初始化方法">
    /**
     * 初始化View，在[onAttachedToWindow]中调用的第一个方法，建议在此方法中进行初始化View状态，设置默认显示值等
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