package com.example.navigationdemo.ui.fragment

import android.os.Bundle
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
import com.example.navigationdemo.ui.activity.AgreementActivity
import com.kakayun.lib_frameworkk.ext.startActivity
import com.kakayun.lib_frameworkk.utils.loge

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
        findNavController().currentBackStackEntry?.let {
            it.savedStateHandle.get<Bundle>("bundle")?.apply {
                getString("userName", "空").loge("回传")
            }
        }
    }

    inner class ProxyClick {
        fun goRegisterPage() {
            FragmentNavigatorExtras(mViewBind.ivLoginImg to "tnRegisterImg").let {
                Bundle().apply {
                    putString("userName", "传给注册页面")
                    findNavController().navigate(R.id.to_register_fragment, this, null, it)
                }
            }

        }

        fun goForgetPage() {
            findNavController().navigate(R.id.to_forget_fragment)
        }

        fun goAgreementPage() {
            var imgPair: Pair<View, String> = Pair(mViewBind.ivLoginImg, "tnAgreeImg")
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(), imgPair
            ).let {
                Bundle().apply {
                    putString("userName", "传给用户协议页面")
                    val extras = ActivityNavigator.Extras.Builder().setActivityOptions(it).build()
                    findNavController().navigate(R.id.to_agreement_activity, this, null, extras)
                }
            }

            /*Bundle().apply {
                putString("userName", "传给用户协议页面")
                requireContext().startActivity<AgreementActivity>(this)
            }*/
        }

        fun goHomePage(){
            findNavController().navigate(R.id.to_home_fragment)
        }
    }

}