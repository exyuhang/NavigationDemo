package com.example.navigationdemo.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.data.bean.CarouselBean
import com.example.navigationdemo.databinding.RecyclerRadioItemBinding

/**
 * Created by YuHang
 * c
 * 5/17/21 11:10 AM
 */
class RadioRecyclerAdapter: BaseQuickAdapter<CarouselBean, BaseViewHolder>(R.layout.recycler_radio_item){

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: CarouselBean) {
        if (item == null) {
            return
        }
        val binding = holder.getBinding<RecyclerRadioItemBinding>()
        binding?.tvRadioTitle?.text = "第${holder.position}条"
    }


}