package com.wacode.yuki.annictforapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.bindView
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.activity.OAuthActivity
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.AnnimeCardContract
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.utils.PrefManager
import com.wacode.yuki.annictforapp.view.MainAnnimeCardAdapter
import com.wacode.yuki.annictforapp.viewmodel.WorksViewModel
import rx.Observable
import java.util.*

class MainActivity : AppCompatActivity(),WorksContract.WorksView,AnnimeCardContract {

    private lateinit var viewModel:WorksViewModel
    private val recyclerview by bindView<RecyclerView>(R.id.main_recycler)
    private lateinit var adapter:MainAnnimeCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
        if(PrefManager(this).AccessToken.equals("")){
            startActivity(Intent(this,OAuthActivity::class.java))
            finish()
        }else {
            viewModel = WorksViewModel((application as AnnictForAppApplication).getWorksApiService(), this)
            viewModel.setViews(this)
            viewModel.getWorks()
        }
    }

    private fun setViews(){
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MainAnnimeCardAdapter(this,this)
        recyclerview.adapter = adapter
    }

    override fun setView(view: AnnimeCardContract.AnnimeCardView) {
    }

    override fun showWorks(entity: WorksEntity) {
        adapter.setItem(entity.works)
    }

    override fun showError() {
        Log.d("aa","errororooor")
    }
}
