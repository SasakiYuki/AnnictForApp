package com.wacode.yuki.annictforapp.view

import android.annotation.TargetApi
import android.content.Context
import android.databinding.ObservableField
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.IdRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.utils.WorkComparator
import rx.Observable
import java.util.*

/**
 * Created by yuki on 2016/09/28.
 */
class RankingRecyclerView :LinearLayout{
    private val title = ObservableField<String>()
    private var arrayList = ArrayList<WorksEntity.Work>()
    private val recyclerView by bindView<RecyclerView>(R.id.ranking_recycler)
    private val textview by bindView<TextView>(R.id.ranking_header_text)
    private lateinit var adapter:RankingAdapter
    @JvmOverloads constructor(context: Context, attrs:AttributeSet? = null,defStyleAttr:Int = 0)
        :super(context,attrs,defStyleAttr){
        initializeViews(context,attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initializeViews(context, attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    private fun initializeViews(context: Context, attrs: AttributeSet?){
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.view_list_ranking,this)
        attrs?.let {
            val attr = context.obtainStyledAttributes(attrs,R.styleable.RankingRecyclerView)
            title.set(attr.getString(R.styleable.RankingRecyclerView_setTitle))
            attr.recycle()
        }

        adapter =RankingAdapter(context,sortWorksEntity())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        textview.typeface = Typeface.DEFAULT_BOLD
        textview.text = title.get()
    }

    private fun sortWorksEntity():ArrayList<RankingEntity>{
        val list = ArrayList<RankingEntity>()
        Collections.sort(arrayList,WorkComparator())
        var count = 1
        Observable.from(arrayList)
                .filter { count<= 5 }
                .map { RankingEntity().setValues(it,count)}
                .subscribe{
                    count++
                    list.add(it)
            }
        return list
    }

    fun setTitle(title:String){
        this.title.set(title)
        textview.text = this.title.get()
    }

    fun setArrayList(arrayList: ArrayList<WorksEntity.Work>){
        this.arrayList = arrayList
        adapter.setItem(sortWorksEntity())
    }

    inner class RankingEntity(){
        val title = ObservableField<String>()
        val id = ObservableField<Int>()
        val watchersCount = ObservableField<String>()
        val icon = ObservableField<Drawable>()

        fun setValues(entity:WorksEntity.Work,ranking:Int):RankingEntity{
            title.set(entity.title)
            id.set(entity.id)
            watchersCount.set(entity.watchers_count.toString())
            icon.set(getRankinDrawable(ranking))
            return this
        }

        private fun getRankinDrawable(ranking: Int): Drawable {
            return when(ranking){
                1 ->getDrawable(R.mipmap.transranking1)
                2 -> getDrawable(R.mipmap.transranking2)
                3 -> getDrawable(R.mipmap.transranking3)
                4 -> getDrawable(R.mipmap.transranking4)
                5 -> getDrawable(R.mipmap.transranking5)
                else -> getDrawable(R.mipmap.transranking5)
            }
        }

        private fun getDrawable(@IdRes resourceId:Int) = context.getDrawable(resourceId)

    }

}