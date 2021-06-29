package com.example.navigationdemo.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.app.ext.glide
import com.example.navigationdemo.data.bean.CarouselBean
import com.example.navigationdemo.databinding.ItemRadioPagerBinding

/**
 * Created by YuHang
 * c
 * 1/7/21 5:09 PM
 */
class RadioPagerAdapter :
    BaseQuickAdapter<CarouselBean, BaseViewHolder>(R.layout.item_radio_pager) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: CarouselBean) {

        item?.apply {
            holder.getBinding<ItemRadioPagerBinding>()?.let {
                it.data = this
                it.ivCarousel.glide(item.imgUrl)
                it.executePendingBindings()
            }
        }
    }


}