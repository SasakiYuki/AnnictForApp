package com.wacode.yuki.annictforapp.utils

/**
 * Created by yuki.n on 2017/02/13.
 */
class PagingHelper {
    public interface LoadCallback {
        /**
         * ページ付コールバック。
         */
        fun onLoadWithPage(page:Int)
    }

    private lateinit var callback:LoadCallback
    private var page = 1;

    public fun setCallback(loadCallback: LoadCallback) {
        callback = loadCallback
    }

    /**
     * pageのリフレッシュを行う。スワイプリフレッシュなどが行われたときに呼び出す。
     */
    public fun refreshPage(): PagingHelper {
        page = 1
        return this
    }

    /**
     * ロード処理の呼び出し。
     * その後ページ番号をインクリメントする。
     */
    public fun requestLoad():PagingHelper {
        callback?.let {
            callback.onLoadWithPage(page)
            page++
        }
        return this
    }

}