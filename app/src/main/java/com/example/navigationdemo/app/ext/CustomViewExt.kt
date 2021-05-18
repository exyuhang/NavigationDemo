package com.example.navigationdemo.app.ext

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.data.bean.CarouselBean

/**
 * Created by YuHang
 * c
 * 4/29/21 4:11 PM
 */

fun ViewPager2.initCarousel(listData: MutableList<CarouselBean>) {
    this.adapter =
        object : BaseQuickAdapter<CarouselBean, BaseViewHolder>(R.layout.item_radio_pager) {
            override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
                DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
            }

            override fun convert(holder: BaseViewHolder, item: CarouselBean) {
                if (item == null) {
                    return
                }
                val binding =
                    holder.getBinding<com.example.navigationdemo.databinding.ItemRadioPagerBinding>()
                binding?.data = item
                Glide.with(context).load(item.imgUrl).into(binding?.ivCarousel!!)
                binding?.executePendingBindings()
            }

        }.apply {
            addData(listData)
        }
}
