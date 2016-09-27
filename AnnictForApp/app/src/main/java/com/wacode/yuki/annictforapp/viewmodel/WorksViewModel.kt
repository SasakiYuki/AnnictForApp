package com.wacode.yuki.annictforapp.viewmodel

import android.content.Context
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.WorksApiService
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.type.SeasonType
import com.wacode.yuki.annictforapp.utils.Works.WorksQueryBuilder
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.*

/**
 * Created by yuki on 2016/09/26.
 */
class WorksViewModel(val service:WorksApiService,val context: Context):WorksContract {
    private lateinit var view:WorksContract.WorksView
    override fun setViews(view: WorksContract.WorksView) {
        this.view = view
    }

    override fun getWorks() {
        service.getWorks(buildQuery())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                getMeWorks(it)
            },{
                view.showError()
                it.printStackTrace()
        })
    }

    private fun getMeWorks(entity:WorksEntity){
        service.getMeWorks(buildQuery())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showWorks(entity,it)
                },{
                    view.showError()
                    it.printStackTrace()
                })

    }

    @SeasonType private fun getCurrentSeason():String{
        val calendar = Calendar.getInstance()
        return when(calendar.get(Calendar.MONTH)+1){
            in 1..3 -> SeasonType.WINTER
            in 4..6 -> SeasonType.SPRING
            in 7..9 -> SeasonType.SUMMER
            in 10..12 -> SeasonType.AUTUMN
            else -> SeasonType.ALL
        }
    }

    private fun getCurrentYear():String{
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR).toString()
    }

    private fun buildQuery() = WorksQueryBuilder(year = getCurrentYear(),filter_season = getCurrentSeason(),context = context).toQueryMap()
}
