package com.wacode.yuki.annictforapp.utils

import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import java.util.*

/**
 * Created by yuki on 2016/09/28.
 */
class WorkComparator :Comparator<WorksEntity.Work>{
    override fun compare(p0: WorksEntity.Work, p1: WorksEntity.Work): Int {
        val p0WatchersCount = p0.watchers_count
        val p1WatchersCount = p1.watchers_count

        if(p0WatchersCount > p1WatchersCount){
            return -1
        }else if(p0WatchersCount == p1WatchersCount){
            return 0
        }else{
            return 1
        }
    }
}