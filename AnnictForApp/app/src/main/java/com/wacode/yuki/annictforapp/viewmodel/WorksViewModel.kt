package com.wacode.yuki.annictforapp.viewmodel

import android.content.Context
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.WorksApiService
import com.wacode.yuki.annictforapp.type.SeasonType
import com.wacode.yuki.annictforapp.utils.PagingHelper
import com.wacode.yuki.annictforapp.utils.Works.WorksQueryBuilder
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by yuki on 2016/09/26.
 */
class WorksViewModel(val service: WorksApiService, val context: Context) : WorksContract, PagingHelper.LoadCallback {
    private lateinit var view: WorksContract.WorksView
    private val pagingHelper: PagingHelper = PagingHelper()

    init {
        pagingHelper.setCallback(this)
    }

    override fun setViews(view: WorksContract.WorksView) {
        this.view = view
    }

    override fun getWorks() {
        service.getWorks(buildQuery())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showWorks(it)
                }, {
                    view.showError()
                    it.printStackTrace()
                })
    }

    override fun onLoadWithPage(page: Int) {
        service.getWorks(buildQuery(page))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showWorks(it)
                }, {
                    view.showError()
                })
    }

    override fun refresh() {
        pagingHelper
                .refreshPage()
                .requestLoad()
    }

    override fun addPage() {
        pagingHelper
                .requestLoad()
    }

    @SeasonType private fun getCurrentSeason(): String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.MONTH) + 1) {
            in 1..3 -> SeasonType.WINTER
            in 4..6 -> SeasonType.SPRING
            in 7..9 -> SeasonType.SUMMER
            in 10..12 -> SeasonType.AUTUMN
            else -> SeasonType.ALL
        }
    }

    private fun getCurrentYear(): String {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR).toString()
    }

    private fun buildQuery() = WorksQueryBuilder(year = getCurrentYear(), filter_season = getCurrentSeason(), context = context).toQueryMap()
    private fun buildQuery(page: Int) = buildQuery(getCurrentYear(), getCurrentSeason(), page = page)
    private fun buildQuery(year: String, seasonType: String, page: Int) = WorksQueryBuilder(year = year, filter_season = seasonType, page = page, context = context).toQueryMap()
}
