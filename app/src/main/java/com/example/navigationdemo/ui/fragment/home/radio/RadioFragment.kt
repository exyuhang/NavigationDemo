package com.example.navigationdemo.ui.fragment.home.radio

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdemo.R
import com.example.navigationdemo.ui.adapter.RadioRecyclerAdapter
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.example.navigationdemo.app.ext.*
import com.example.navigationdemo.databinding.FragmentRadioBinding
import com.example.navigationdemo.viewmodel.RadioViewModel
import com.kakayun.lib_frameworkk.ext.init
import com.kakayun.lib_frameworkk.ext.loadListData
import com.kakayun.lib_frameworkk.ext.loadServiceInit
import com.kakayun.lib_frameworkk.ext.showLoading
import com.kingja.loadsir.core.LoadService
import kotlinx.android.synthetic.main.fragment_radio.*
import kotlinx.android.synthetic.main.include_recyclerview.*

/**
 * Created by YuHang
 * c
 * 2020/12/16 10:31 AM
 */
class RadioFragment : BaseFragment<RadioViewModel, FragmentRadioBinding>() {

    //界面状态管理者
    private lateinit var loadSir: LoadService<Any>

    private val adapter: RadioRecyclerAdapter by lazy {
        RadioRecyclerAdapter()
    }

    override fun getLayoutId(): Int = R.layout.fragment_radio

    override fun initView(rootView: View) {
        super.initView(rootView)
        //状态页配置
        loadSir = loadServiceInit(swipeRefresh) {
            //点击重试时触发的操作
            loadSir.showLoading()
            mViewModel.loadCarousel(true)
        }

        swipeRefresh.init {
            mViewModel.loadCarousel(true)
        }

        recyclerView.init(LinearLayoutManager(context), adapter = adapter)
    }

    override fun lazyLoadData() {
        loadSir.showLoading()
        mViewBind.click = RadioClick()
        lifecycle.addObserver(RadioViewModel())
        mViewModel?.run {
            radioCarousel.observe(viewLifecycleOwner, Observer {
                radioPager.initCarousel(it.listData)
                loadListData(it, adapter, loadSir, recyclerView, swipeRefresh)
            })
        }
        mViewModel.loadCarousel(true)
    }


    inner class RadioClick {

        fun loadCarousel() {
            mViewModel.loadCarousel(true)
        }
    }

}