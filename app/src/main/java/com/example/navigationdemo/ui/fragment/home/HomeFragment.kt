package com.example.navigationdemo.ui.fragment.home

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.FragmentHomeBinding

/**
 * Created by YuHang
 * c
 * 2020/12/16 9:30 AM
 */
class HomeFragment: BaseFragment<BaseViewModel, FragmentHomeBinding>(){

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView(rootView: View) {
        super.initView(rootView)
        var navHostFragment =
            childFragmentManager?.findFragmentById(R.id.fv_Home) as NavHostFragment
        mViewBind.bvHome.setupWithNavController(navHostFragment.navController)
    }

    override fun lazyLoadData() {

    }


}