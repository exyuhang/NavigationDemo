package com.example.navigationdemo.ui.fragment

import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.FragmentForgetBinding

/**
 * Created by YuHang
 * 忘记密码
 * 2020/12/11 11:20 AM
 */

class ForgetFragment: BaseFragment<BaseViewModel, FragmentForgetBinding>(){

    override fun getLayoutId(): Int = R.layout.fragment_forget

}