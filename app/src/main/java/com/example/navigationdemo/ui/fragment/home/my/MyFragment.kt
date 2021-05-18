package com.example.navigationdemo.ui.fragment.home.my

import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.FragmentHomepageBinding

/**
 * Created by YuHang
 * c
 * 2020/12/16 10:31 AM
 */
class MyFragment: BaseFragment<BaseViewModel, FragmentHomepageBinding>(){

    override fun getLayoutId(): Int = R.layout.fragment_my

    override fun lazyLoadData() {

    }

}