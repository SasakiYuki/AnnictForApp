package com.wacode.yuki.annictforapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import butterknife.bindView
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.activity.OAuthActivity
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.AnnimeCardContract
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.utils.PrefManager
import com.wacode.yuki.annictforapp.view.MainAnnimeCardAdapter
import com.wacode.yuki.annictforapp.view.viewpager.MainViewPagerAdapter
import com.wacode.yuki.annictforapp.viewmodel.WorksViewModel
import rx.Observable
import java.util.*

class MainActivity : AppCompatActivity(),WorksContract.WorksView,AnnimeCardContract {

    private lateinit var viewModel:WorksViewModel
    private val viewPager by bindView<ViewPager>(R.id.main_viewpager)
    private val toolbar by bindView<Toolbar>(R.id.main_toolbar)
    private val drawerLayout by bindView<DrawerLayout>(R.id.main_drawer)

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
        setSupportActionBar(toolbar)
        val manager = supportFragmentManager
        val adapter = MainViewPagerAdapter(manager)
        viewPager.adapter = adapter
        setDrawer()
        val tabLayout = findViewById(R.id.main_tab) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setDrawer() {
        val navigationView = findViewById(R.id.main_drawer_navigation) as NavigationView

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout.setDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(select)
    }

    private val select = NavigationView.OnNavigationItemSelectedListener {
        //本来ならここで分岐の処理を
        drawerLayout.closeDrawers()
        true
    }

    override fun setView(view: AnnimeCardContract.AnnimeCardView) {
    }

    override fun showWorks(entity: WorksEntity) {
    }

    override fun showError() {
        Log.d("aa","errororooor")
    }
}
