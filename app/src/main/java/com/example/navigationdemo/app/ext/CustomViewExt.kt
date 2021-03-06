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
import com.example.navigationdemo.databinding.ItemRadioPagerBinding
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.navigationdemo.data.bean.BannerResponse
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by YuHang
 * c
 * 4/29/21 4:11 PM
 */

fun ViewPager2.initCarousel(listData: MutableList<BannerResponse>) {
    this.adapter =
        object : BaseQuickAdapter<BannerResponse, BaseViewHolder>(R.layout.item_radio_pager) {
            override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
                DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
            }

            override fun convert(holder: BaseViewHolder, item: BannerResponse) {
                item?.let {
                    holder.getBinding<ItemRadioPagerBinding>()?.apply {
                        data = it
                        executePendingBindings()
                    }
                }

            }

        }.apply {
            addData(listData)
        }

}

fun ImageView.glide(imgUrl: String) {
    Glide.with(context)
        .load(imgUrl)
        .placeholder(R.drawable.icon_banner_place)
        .into(this)
}

fun FrameLayout.initTabPage(
    manager: FragmentManager,
    bottomNavigationItemView: BottomNavigationView,
    viewID: Int,
    vararg fragments: Fragment
) {
    manager.beginTransaction().apply {
        fragments.forEach {
            add(viewID, it)
        }
        commit()
    }

    showFragment(manager, 0, *fragments)

    bottomNavigationItemView.setOnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_homepage -> showFragment(manager, 0, *fragments)
            R.id.home_radio -> showFragment(manager, 1, *fragments)
            R.id.home_message -> showFragment(manager, 2, *fragments)
            R.id.home_my -> showFragment(manager, 3, *fragments)

        }
        true
    }

}

fun showFragment(manager: FragmentManager, index: Int, vararg fragments: Fragment) {
    manager.beginTransaction().apply {
        for (i in fragments.indices) {
            if (i == index) {
                show(fragments[i])
            } else {
                hide(fragments[i])
            }
        }
        commit()
    }

}
