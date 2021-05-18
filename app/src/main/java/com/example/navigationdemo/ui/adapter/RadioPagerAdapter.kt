package com.example.navigationdemo.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
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
        if (item == null) {
            return
        }
        val binding = holder.getBinding<ItemRadioPagerBinding>()
        binding?.data = item
        Glide.with(context).load(item.imgUrl).into(binding?.ivCarousel!!)
        binding?.executePendingBindings()
    }


}