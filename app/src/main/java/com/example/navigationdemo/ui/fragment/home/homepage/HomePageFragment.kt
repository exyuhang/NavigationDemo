package com.example.navigationdemo.ui.fragment.home.homepage

import android.view.View
import androidx.lifecycle.LiveData
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
    private var age: Int = 0
    private var homeRecyclerAdapter: HomeRecyclerAdapter? = null
    private var listData: MutableList<UserInfo>? = null
    private var allUserLive: LiveData<List<UserInfo>>? = null

    override fun getLayoutId(): Int = R.layout.fragment_homepage

    override fun initView(rootView: View) {
        super.initView(rootView)
        mViewBind.click = ProxyClick()
        mViewBind.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
        homeRecyclerAdapter = HomeRecyclerAdapter()
        mViewBind.recyclerHome.adapter = homeRecyclerAdapter
    }

    private fun queryData(){
        allUserLive = mViewModel?.getAllUserInfo()
        allUserLive?.observe(this,
            Observer<List<UserInfo>> {
                listData = it as MutableList<UserInfo>?
                homeRecyclerAdapter?.data = it as MutableList<UserInfo>
                homeRecyclerAdapter?.notifyDataSetChanged()
            })
    }


    inner class ProxyClick{

        fun add(){
            mViewModel.insertUserInfo(UserInfo("张三", age++))
        }

        fun delete(){
            if (listData?.size?:0 > 0){
                mViewModel.deleteUserInfo(listData?.get(0)!!)
            }
        }

        fun update(){
            if (listData?.size!! > 0){
                listData?.get(0)?.name = "张四"
                mViewModel.updateUserInfo(listData?.get(0)!!)
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