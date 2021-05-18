package com.example.navigationdemo.ui.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.FragmentRegisterBinding

/**
 * Created by YuHang
 * 注册
 * 2020/12/11 11:19 AM
 */
class RegisterFragment : BaseFragment<BaseViewModel, FragmentRegisterBinding>() {

    override fun getLayoutId(): Int =
        R.layout.fragment_register

    override fun initView(rootView: View) {
        super.initView(rootView)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
        mViewBind.click = ProxyClick()
        Log.e("传值", arguments?.getString("userName")!!)
    }

    inner class ProxyClick{

        fun goLoginPage(){
            var bundle = Bundle()
            bundle.putString("userName", "注册页面回传值")
            findNavController().previousBackStackEntry
                ?.savedStateHandle?.set("bundle", bundle)
            findNavController().popBackStack()
        }
    }


}