package com.wacode.yuki.annictforapp.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.AnnimeCardContract
import com.wacode.yuki.annictforapp.databinding.ViewCardAnnimeBinding
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.viewmodel.AnnimeCardViewModel
import java.util.*

/**
 * Created by yuki on 2016/09/27.
 */
class MainAnnimeCardAdapter(private val context:Context,
                            private val view:AnnimeCardContract) :RecyclerView.Adapter<MainAnnimeCardAdapter.MainAnnimeCardViewHolder>(){
    private var works:ArrayList<WorksEntity.Work> = ArrayList()

    fun setItem(works:ArrayList<WorksEntity.Work>){
        this.works = works
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int) = works[position]


    override fun getItemCount() = works.size

    override fun onBindViewHolder(holder: MainAnnimeCardViewHolder, position: Int) {
        val item = getItemAt(position)
        holder.loadItem(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainAnnimeCardViewHolder {
        val binding= DataBindingUtil.inflate<ViewCardAnnimeBinding>(LayoutInflater.from(context), R.layout.view_card_annime,parent,false)
        binding.annimeCardModel = AnnimeCardViewModel(context)
        return MainAnnimeCardViewHolder(binding.root, binding.annimeCardModel)
    }


    inner class MainAnnimeCardViewHolder(itemView: View,private val viewModel: AnnimeCardViewModel? ):RecyclerView.ViewHolder(itemView){
        fun loadItem(item:WorksEntity.Work){
            viewModel!!.loadData(item)
        }
    }
}