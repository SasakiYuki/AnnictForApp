package com.wacode.yuki.annictforapp.viewmodel

import com.wacode.yuki.annictforapp.utils.OAuth.OAuthQueryBuilder
import com.wacode.yuki.annictforapp.contract.AccessTokenContract
import com.wacode.yuki.annictforapp.rest.OAuthAPIService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by yuki on 2016/09/26.
 */
class AccessTokenViewModel(val service: OAuthAPIService) : AccessTokenContract {

    private lateinit var view: AccessTokenContract.AccessTokenView

    override fun setView(view: AccessTokenContract.AccessTokenView) {
        this.view = view
    }

    override fun getAccessToken(code: String) {
        service.getAccessToken(buildQuery(code))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.storeAccessToken(it.access_token)
                },{
                    view.showError()
                    it.printStackTrace()
                })
    }

    private fun buildQuery(code: String) = OAuthQueryBuilder(code).toQueryMap()
}