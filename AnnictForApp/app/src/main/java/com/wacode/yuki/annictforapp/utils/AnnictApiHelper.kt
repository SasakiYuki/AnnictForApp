package com.wacode.yuki.annictforapp.utils

import android.accounts.AccountManager
import jp.hunza.blog.utils.PrefUtils

/**
 * Created by yuki on 2016/06/10.
 */
object AnnictApiHelper {
    const val Q_ACCESS_TOKEN = "access_token"
    const val Q_FIELDS = "fields"
    const val Q_FILTER_IDS = "filter_ids"
    const val Q_FILTER_SEASON = "filter_season"
    const val Q_FILTER_TITLE = "filter_title"
    const val Q_FILTER_STATUS = "filter_status"
    const val Q_PAGE = "page"
    const val Q_PER_PAGE ="per_page"
    const val Q_SORT_ID = "sort_id"
    const val Q_SORT_SEASON = "sort_season"
    const val Q_SORT_WATCHERS_COUNT ="sort_watchers_count"
    const val Q_WORK_ID = "work_id"
    const val Q_KIND = "kind"
    const val Q_FILTER_WORK_ID = "filter_work_id"
    const val Q_SORT_SORT_NUMBER = "sort_sort_number"
    const val Q_SORT_LIKE_COUNT = "sort_likes_count"
    const val Q_FILTER_EPISODE_ID = "filter_episode_id"
    const val Q_EPISODE_ID = "episode_id"
    const val Q_COMMENT = "comment"
    const val Q_RATING = "rating"
    const val Q_SHARE_TWITTER = "share_twitter"
    const val Q_SORT_STARTED_AT = "sort_started_at"

    const val id = "id"
    const val title: String = "title"
    const val title_kana: String = "title_kana"
    const val media: String = "media"
    const val media_text: String = "media_text"
    const val season_name: String = "season_name"
    const val season_name_text: String = "season_name_text"
    const val release_on: String = "release_on"
    const val release_on_about: String = "release_on_about"
    const val official_site_url: String = "official_site_url"
    const val wikipedia_url: String = "wikipedia_url"
    const val twitter_username: String = "tiwtter_username"
    const val Twitter_hashtag: String = "Twitter_hashtag"
    const val episodes_count: String = "episodes_count"
    const val watchers_count: String= "watchers_count"
    const val wanna_watch = "wanna_watch"
    const val watching = "watching"
    const val watched ="watched"
    const val on_hold = "on_hold"
    const val stop_watching = "stop_watching"
    const val no_data = "no_select"
    const val asc = "asc"
    const val desc= "desc"
}