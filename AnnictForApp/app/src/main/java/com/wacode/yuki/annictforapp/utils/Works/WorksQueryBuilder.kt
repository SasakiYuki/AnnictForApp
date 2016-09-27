package com.wacode.yuki.annictforapp.utils.Works

import android.content.Context
import com.wacode.yuki.annictforapp.type.SeasonType
import com.wacode.yuki.annictforapp.utils.AnnictApiHelper
import com.wacode.yuki.annictforapp.utils.PrefManager
import java.util.*

/**
 * Created by yuki on 2016/09/26.
 */
class WorksQueryBuilder(
        val filter_id:Int? = null,
        @SeasonType val filter_season:String? = null,
        val year:String? = null,
        val filter_title:String? = null,
        val page:Int = 1,
        val per_page:Int = 50,
        val sort_id:String = "asc",
        val sort_season:String = "asc",
        val sort_watchers_count:String = "asc",
        val context: Context
) {
    fun toQueryMap():Map<String,String>{
        return object :HashMap<String,String>(){
            init {
                filter_id?.let {
                    put(AnnictApiHelper.Q_FILTER_IDS,filter_id.toString())
                }
                filter_season?.let {
                    year?.let {
                        val season = year + "-" + filter_season
                        put(AnnictApiHelper.Q_FILTER_SEASON,season)
                    }
                }
                filter_title?.let {
                    put(AnnictApiHelper.Q_FILTER_TITLE,filter_title)
                }
                put(AnnictApiHelper.Q_PAGE,page.toString())
                put(AnnictApiHelper.Q_PER_PAGE,per_page.toString())
                put(AnnictApiHelper.Q_SORT_ID,sort_id)
                put(AnnictApiHelper.Q_SORT_SEASON,sort_season)
                put(AnnictApiHelper.Q_SORT_WATCHERS_COUNT,sort_watchers_count)
                put(AnnictApiHelper.Q_ACCESS_TOKEN,PrefManager(context).AccessToken)
            }
        }
    }

}