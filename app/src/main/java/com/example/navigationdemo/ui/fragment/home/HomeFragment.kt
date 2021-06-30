package com.example.navigationdemo.ui.fragment.home

import android.view.View
import android.widget.FrameLayout
import com.example.navigationdemo.R
import com.example.navigationdemo.app.ext.initTabPage
import com.example.navigationdemo.databinding.FragmentHomeBinding
import com.example.navigationdemo.ui.fragment.home.homepage.HomePageFragment
import com.example.navigationdemo.ui.fragment.home.message.MessageFragment
import com.example.navigationdemo.ui.fragment.home.my.MyFragment
import com.example.navigationdemo.ui.fragment.home.radio.RadioFragment
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel


/**
 * Created by YuHang
 * 上传git
 * 2020/12/16 9:30 AM
 */
class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView(rootView: View) {
        super.initView(rootView)
        mViewBind.frameLayout.initTabPage(childFragmentManager, mViewBind.bvHome, R.id.frameLayout, HomePageFragment(), RadioFragment(),  MessageFragment(), MyFragment())
    }


}

