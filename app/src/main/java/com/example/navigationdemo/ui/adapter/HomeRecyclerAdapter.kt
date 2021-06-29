package com.example.navigationdemo.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.app.room.UserInfo
import com.example.navigationdemo.databinding.RecyclerHomeItemBinding

/**
 * Created by YuHang
 * c
 * 2020/12/17 4:31 PM
 */
class HomeRecyclerAdapter: BaseQuickAdapter<UserInfo, BaseViewHolder>(R.layout.recycler_home_item){

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: UserInfo) {

        item?.apply {
            holder.getBinding<RecyclerHomeItemBinding>()?.let {
                it.data = this
                it.executePendingBindings()
            }
        }

    }


}