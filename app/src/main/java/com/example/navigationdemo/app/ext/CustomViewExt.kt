package com.example.navigationdemo.app.ext

import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.navigationdemo.R
import com.example.navigationdemo.data.bean.CarouselBean
import com.example.navigationdemo.databinding.ItemRadioPagerBinding
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

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

fun ImageView.glide(imgUrl: String) {
    Glide.with(context).load(imgUrl).into(this)
}

fun FrameLayout.initTabPage(
    manager: FragmentManager,
    bottomNavigationItemView: BottomNavigationView,
    viewID: Int,
    vararg fragments: Fragment
) {
    manager.beginTransaction().apply {
        add(viewID, fragments[0])
        add(viewID, fragments[1])
        add(viewID, fragments[2])
        add(viewID, fragments[3])
        show(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).commit()
    }


    bottomNavigationItemView.setOnNavigationItemSelectedListener { item ->
        if (item.itemId == R.id.home_homepage) {
            manager.beginTransaction().apply {
                show(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                    .commit()
            }

        }

        if (item.itemId == R.id.home_radio) {
            manager.beginTransaction().apply {
                hide(fragments[0]).show(fragments[1]).hide(fragments[2]).hide(fragments[3])
                    .commit()
            }
        }

        if (item.itemId == R.id.home_message) {
            manager.beginTransaction().apply {
                hide(fragments[0]).hide(fragments[1]).show(fragments[2]).hide(fragments[3])
                    .commit()
            }
        }

        if (item.itemId == R.id.home_my) {
            manager.beginTransaction().apply {
                hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).show(fragments[3])
                    .commit()
            }
        }

        true
    }

}