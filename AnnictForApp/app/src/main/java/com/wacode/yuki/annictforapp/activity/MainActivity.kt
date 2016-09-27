package com.wacode.yuki.annictforapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.activity.OAuthActivity
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.utils.PrefManager
import com.wacode.yuki.annictforapp.viewmodel.WorksViewModel

class MainActivity : AppCompatActivity(),WorksContract.WorksView {
    private lateinit var viewModel:WorksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(PrefManager(this).AccessToken.equals("")){
            startActivity(Intent(this,OAuthActivity::class.java))
            finish()
        }else {
            viewModel = WorksViewModel((application as AnnictForAppApplication).getWorksApiService(), this)
            viewModel.setViews(this)
            viewModel.getWorks()
        }
    }

    override fun showWorks(entity: WorksEntity, meWork: WorksEntity) {
        Log.d("aa","mariodesu")
    }

    override fun showError() {
        Log.d("aa","errororooor")
    }
}
