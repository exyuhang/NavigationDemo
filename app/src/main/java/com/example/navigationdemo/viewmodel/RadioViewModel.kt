package com.example.navigationdemo.viewmodel

import androidx.lifecycle.*
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.kakayun.lib_frameworkk.ext.request
import com.example.navigationdemo.data.bean.AriticleResponse
import com.example.navigationdemo.data.bean.BannerResponse
import com.example.navigationdemo.data.repository.httpRepository
import com.kakayun.lib_frameworkk.livedata.ResultState
import com.kakayun.lib_frameworkk.net.stateCallback.ListDataUiState
import com.kakayun.lib_frameworkk.utils.loge

/**
 * Created by YuHang
 * c
 * 1/7/21 3:57 PM
 */
class RadioViewModel : BaseViewModel(), LifecycleEventObserver, LifecycleObserver {

    //页码 首页数据页码从0开始
    var pageNo = 0

    var radioAriticleList = MutableLiveData<ListDataUiState<AriticleResponse>>()

    var bannerData = MutableLiveData<ResultState<ArrayList<BannerResponse>>>()


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        "onCreate".loge("@LifeCycle")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        "onStart".loge("@LifeCycle")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        "onResume".loge("@LifeCycle")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        "onStop".loge("@LifeCycle")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        "onPause".loge("@LifeCycle")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        "onDestroy".loge("@LifeCycle")
    }

    fun loadArticlelList(isRefresh: Boolean) {
        if (isRefresh){
            pageNo = 0
        }
        request({ httpRepository.getArticlelList(pageNo) }, {
            //请求成功
            pageNo++
            val listDataUiState =
                ListDataUiState(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = it.hasMore(),
                    isFirstEmpty = it.isEmpty(),
                    listData = it.datas
                )
            radioAriticleList.value = listDataUiState
        }, {
            //请求失败
            "请求失败${it.errorMsg}".loge("网络请求")
            val listDataUiState =
                ListDataUiState(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = arrayListOf<AriticleResponse>()
                )
            radioAriticleList.value = listDataUiState
        })
    }

    fun loadBannerData(){
        request({httpRepository.getBannerData()}, bannerData)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                "ON_CREATE".loge("LifeCycle")
            }

            Lifecycle.Event.ON_START -> {
                "ON_START".loge("LifeCycle")
            }

            Lifecycle.Event.ON_RESUME -> {
                "ON_RESUME".loge("LifeCycle")
            }

            Lifecycle.Event.ON_PAUSE -> {
                "ON_PAUSE".loge("LifeCycle")
            }

            Lifecycle.Event.ON_STOP -> {
                "ON_STOP".loge("LifeCycle")
            }

            Lifecycle.Event.ON_DESTROY -> {
                "ON_DESTROY".loge("LifeCycle")
            }

        }
    }

}