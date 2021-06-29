package com.example.navigationdemo.ui.fragment.home.homepage

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdemo.R
import com.example.navigationdemo.ui.adapter.HomeRecyclerAdapter
import com.kakayun.lib_frameworkk.base.BaseFragment
import com.example.navigationdemo.viewmodel.HomeViewModel
import com.example.navigationdemo.app.room.UserInfo
import com.example.navigationdemo.databinding.FragmentHomepageBinding

/**
 * Created by YuHang
 * c
 * 2020/12/16 10:31 AM
 */
class HomePageFragment: BaseFragment<HomeViewModel, FragmentHomepageBinding>(){

    private val homeRecyclerAdapter: HomeRecyclerAdapter by lazy {
        HomeRecyclerAdapter()
    }
    private var age: Int = 0
    private var listData: MutableList<UserInfo>? = null

    override fun getLayoutId(): Int = R.layout.fragment_homepage

    override fun initView(rootView: View) {
        super.initView(rootView)
        mViewBind?.apply {
            click = ProxyClick()
            recyclerHome.layoutManager = LinearLayoutManager(requireContext())
            recyclerHome.adapter = homeRecyclerAdapter
        }
    }

    private fun queryData(){

        mViewModel?.run {
            getAllUserInfo().observe(this@HomePageFragment, Observer<List<UserInfo>> {
                listData = it as MutableList<UserInfo>?
                homeRecyclerAdapter?.apply {
                    data = listData!!
                    notifyDataSetChanged()
                }
            })
        }

    }


    inner class ProxyClick{

        fun add(){
            mViewModel.insertUserInfo(UserInfo("张三", age++))
        }

        fun delete(){
            listData?.let {
                if (it.size > 0){
                    mViewModel.deleteUserInfo(it[0])
                }
            }
        }

        fun update(){
            listData?.let {
                if (it.size > 0){
                    it[0].name = "张四"
                    mViewModel.updateUserInfo(it[0])
                }
            }
        }

        fun query(){
            queryData()
        }

        fun clear(){
            mViewModel.clearUserInfo()
        }

    }

    override fun lazyLoadData() {
        queryData()
    }

}