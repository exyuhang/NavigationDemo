package com.example.navigationdemo.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.kakayun.lib_frameworkk.ext.request
import com.example.navigationdemo.data.bean.CarouselBean
import com.example.navigationdemo.data.repository.httpRepository
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

    var radioCarousel = MutableLiveData<ListDataUiState<CarouselBean>>()


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        Log.e("@LifeCycle", "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        Log.e("@LifeCycle", "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        Log.e("@LifeCycle", "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        Log.e("@LifeCycle", "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        Log.e("@LifeCycle", "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        Log.e("@LifeCycle", "onDestroy")
    }

    fun loadCarousel(isRefresh: Boolean) {
        if (isRefresh){
            pageNo = 0
        }
        var mapData = mutableMapOf<String, String>()
        request({ httpRepository.getCarousel(mapData) }, {
            //请求成功
            pageNo++
            val uiState =
                ListDataUiState(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = false,
                    isFirstEmpty = it.isEmpty(),
                    listData = it
                )
            radioCarousel.value = uiState
        }, {
            //请求失败
            "请求失败${it.errorMsg}".loge("网络请求")
            val uiState =
                ListDataUiState(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = arrayListOf<CarouselBean>()
                )
            radioCarousel.value = uiState
        })
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.e("LifeCycle", "ON_CREATE")
            }

            Lifecycle.Event.ON_START -> {
                Log.e("LifeCycle", "ON_START")
            }

            Lifecycle.Event.ON_RESUME -> {
                Log.e("LifeCycle", "ON_RESUME")
            }

            Lifecycle.Event.ON_PAUSE -> {
                Log.e("LifeCycle", "ON_PAUSE")
            }

            Lifecycle.Event.ON_STOP -> {
                Log.e("LifeCycle", "ON_STOP")
            }

            Lifecycle.Event.ON_DESTROY -> {
                Log.e("LifeCycle", "ON_DESTROY")
            }

        }
    }

}