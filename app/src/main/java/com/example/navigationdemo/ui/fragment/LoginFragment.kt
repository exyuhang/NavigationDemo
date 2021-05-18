package com.example.navigationdemo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.FragmentLoginBinding

/**
 * Created by YuHang
 * c
 * 2020/12/14 3:42 PM
 */
class LoginFragment : BaseFragment<BaseViewModel, FragmentLoginBinding>() {

    override fun getLayoutId(): Int =
        R.layout.fragment_login

    override fun initView(rootView: View) {
        mViewBind.click = ProxyClick()
        val bundle =
            findNavController().currentBackStackEntry?.savedStateHandle?.get<Bundle>("bundle")
        Log.e("回传", bundle?.getString("userName")?:"")
    }

    inner class ProxyClick {
        fun goRegisterPage() {
            val extras = FragmentNavigatorExtras(mViewBind.ivLoginImg to "tnRegisterImg")
            var bundle = Bundle()
            bundle.putString("userName", "传给注册页面")
            findNavController().navigate(R.id.to_register_fragment, bundle, null, extras)
        }

        fun goForgetPage() {
            findNavController().navigate(R.id.to_forget_fragment)
        }

        fun goAgreementPage() {
            var imgPair: Pair<View, String> = Pair(mViewBind.ivLoginImg, "tnAgreeImg")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(), imgPair
            )
            val bundle = Bundle()
            bundle.putString("userName", "传给用户协议页面")
            val extras = ActivityNavigator.Extras.Builder().setActivityOptions(options).build()
            findNavController().navigate(R.id.to_agreement_activity, bundle, null, extras)
        }

        fun goHomePage(){
            findNavController().navigate(R.id.to_home_fragment)
        }
    }

}