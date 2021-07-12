package com.example.navigationdemo.ui.fragment.home.radio

import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdemo.R
import com.example.navigationdemo.app.ext.initCarousel
import com.example.navigationdemo.ui.adapter.RadioRecyclerAdapter
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.example.navigationdemo.databinding.FragmentRadioBinding
import com.example.navigationdemo.viewmodel.RadioViewModel
import com.kakayun.lib_frameworkk.ext.*
import com.kakayun.lib_frameworkk.ext.init
import com.kakayun.lib_frameworkk.weight.recyclerview.DefineLoadMoreView
import com.kingja.loadsir.core.LoadService
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.include_recyclerview.*
import kotlinx.android.synthetic.main.layout_banner.view.*

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
            mViewModel.loadBannerData()
            mViewModel.loadArticlelList(true)
        }

        swipeRefresh.refresh {
            mViewModel.loadArticlelList(true)
        }

        recyclerView.init(LinearLayoutManager(context), adapter = adapter).apply{
            val footerView = DefineLoadMoreView(requireContext())
            addFooterView(footerView)
            setLoadMoreView(footerView)
            setLoadMoreListener {
                mViewModel.loadArticlelList(false)
            }
        }
    }

    override fun lazyLoadData() {
        loadSir.showLoading()
        lifecycle.addObserver(RadioViewModel())
        mViewModel?.run {
            radioAriticleList.observe(viewLifecycleOwner, Observer {
                loadListData(it, adapter, loadSir, recyclerView, swipeRefresh)
            })

            bannerData.observe(viewLifecycleOwner, {
                parseState(it, { data ->
                    if (recyclerView.headerCount == 0){
                        val headerView = LayoutInflater.from(requireContext())
                            .inflate(R.layout.layout_banner, null).apply {
                            radioPager.initCarousel(data)
                        }
                        recyclerView.addHeaderView(headerView)
                    }
                })
            })
        }
        mViewModel.loadBannerData()
        mViewModel.loadArticlelList(true)
    }

}