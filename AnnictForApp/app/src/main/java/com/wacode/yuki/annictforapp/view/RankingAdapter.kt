package com.wacode.yuki.annictforapp.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.graphics.drawable.Drawable
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wacode.yuki.annictforapp.BR
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import java.util.*

/**
 * Created by yuki on 2016/09/28.
 */
class RankingAdapter( context: Context,private var item:ArrayList<RankingRecyclerView.RankingEntity>):RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {

    private val layoutInflater: LayoutInflater
    private val itemLayoutResource:Int

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        itemLayoutResource = R.layout.layout_ranking_item
    }

    fun setItem(item:ArrayList<RankingRecyclerView.RankingEntity>){
        this.item = item
        notifyDataSetChanged()
    }
    override fun getItemCount() = item.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = RankingViewHolder(layoutInflater.inflate(itemLayoutResource,parent,false))

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.binding.setVariable(BR.rankingEntity,item[position])
    }


    inner class RankingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding:ViewDataBinding = DataBindingUtil.bind(itemView)
    }
}