package com.example.navigationdemo.app.ext

import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.data.bean.CarouselBean
import com.example.navigationdemo.databinding.ItemRadioPagerBinding

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
                item?.let {
                    holder.getBinding<ItemRadioPagerBinding>()?.apply {
                        data = it
                        ivCarousel.glide(it.imgUrl)
                        executePendingBindings()
                    }
                }

            }

        }.apply {
            addData(listData)
        }

}

fun ImageView.glide(imgUrl: String){
    Glide.with(context).load(imgUrl).into(this)
}
