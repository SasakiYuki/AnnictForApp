package com.wacode.yuki.annictforapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.databinding.ViewCardAnnimeBinding
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.viewmodel.AnnimeCardViewModel
import java.text.FieldPosition
import java.util.*

/**
 * Created by yuki.n on 2017/02/16.
 */
open class AnnimeCardAdapter(val context:Context) : BaseRecyclerAdapter<ViewHolder>() {
    private val arrayList:ArrayList<WorksEntity.Work> = ArrayList()

    override val sectionCount: Int
        get() = if(arrayList.size > 0) 1 else 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        return onCreateRowViewHolder(parent)
    }

    override fun getRowCount(section: Int) = arrayList.size

    override fun onBindViewHolder(holder: ViewHolder, indexPath: IndexPath?) {
        @ViewType val viewType = getItemViewType(indexPath!!)
        onBindRowViewHolder(holder,indexPath)
    }

    private fun onBindRowViewHolder(holder: ViewHolder, indexPath: IndexPath?) {
        val binding = (holder as RowViewHolder).viewDataBinding
        val viewModel = AnnimeCardViewModel(context)
        viewModel.loadData(getItemAt(indexPath))
        binding.annimeCardModel = viewModel
        binding.executePendingBindings()
    }

    fun setWorks(list: ArrayList<WorksEntity.Work>) {
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItemAt(position: IndexPath?) = arrayList[position!!.section]

    private fun onCreateRowViewHolder(parent: ViewGroup) : RowViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_card_annime,parent,false)
        return RowViewHolder(view)
    }

    internal class RowViewHolder(itemView: View) : BindingViewHolder<ViewCardAnnimeBinding>(itemView)
}