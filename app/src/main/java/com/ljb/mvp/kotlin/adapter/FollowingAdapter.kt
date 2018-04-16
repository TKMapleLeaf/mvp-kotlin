package com.ljb.mvp.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.common.findViewByIdEx
import com.ljb.mvp.kotlin.domain.Following
import com.ljb.mvp.kotlin.img.ImageLoader
import com.ljb.mvp.kotlin.widget.loadmore.LoadMoreRecyclerAdapter

/**
 * Created by L on 2017/10/9.
 */
class FollowingAdapter(mContext: Context, mData: MutableList<Following>) : LoadMoreRecyclerAdapter<Following>(mContext, mData) {

    override fun getItemHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
            FollowingViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_following, parent, false))

    override fun onBindData(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FollowingViewHolder) {
            val item = mData[position]
            holder.tv_following_name.text = item.login
            ImageLoader.load(
                    context = mContext,
                    url = item.avatar_url,
                    loadingImgResId = R.drawable.default_header,
                    loadErrorImgResId = R.drawable.default_header,
                    form = ImageLoader.ImageForm.ROUND,
                    img = holder.iv_avatar
            )
        }
    }


    class FollowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_following_name by lazy { itemView.findViewByIdEx<TextView>(R.id.tv_following_name) }
        val iv_avatar by lazy { itemView.findViewByIdEx<ImageView>(R.id.iv_avatar) }
    }
}