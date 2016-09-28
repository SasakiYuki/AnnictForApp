package com.wacode.yuki.annictforapp.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.AnnimeCardContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.type.MaterialType
import java.util.*

/**
 * Created by yuki on 2016/09/27.
 */
class AnnimeCardViewModel(val context: Context) :AnnimeCardContract{
    private lateinit var view:AnnimeCardContract.AnnimeCardView
    val title_icon = ObservableField<String>()
    val title_kana  = ObservableField<String>()
    val title = ObservableField<String>()
    val watchers_count = ObservableField<String>()
    val id = ObservableField<Int>()
    val season_name = ObservableField<String>()
    val shapeDrawable = ObservableField<ShapeDrawable>()

    override fun setView(view: AnnimeCardContract.AnnimeCardView) {
        this.view = view
    }

    fun loadData(entity:WorksEntity.Work){
        id.set(entity.id)
        title.set(entity.title)
        title_icon.set(entity.title_kana[0].toString())
        title_kana.set(entity.title_kana)
        watchers_count.set(entity.watchers_count.toString())
        season_name.set(context.getString(R.string.com_card_season,entity.season_name_text))
        shapeDrawable.set(getDrawable())
    }

    private fun getDrawable():ShapeDrawable{
        val shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.paint.color = context.resources.getColor(MaterialType.values()[Random().nextInt(MaterialType.values().size)].colorResource)
        return shapeDrawable
    }


}