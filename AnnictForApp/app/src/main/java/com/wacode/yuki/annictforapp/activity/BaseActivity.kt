package com.wacode.yuki.annictforapp.activity

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.wacode.yuki.annictforapp.R


abstract class BaseActivity : AppCompatActivity() {


    fun initBackToolBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            val actionbar = it
            actionbar.title = toolbar.title
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setDisplayShowHomeEnabled(true)
            actionbar.setDisplayShowTitleEnabled(true)
            actionbar.setHomeButtonEnabled(true)
        }

    }

    fun setToolbarText(title:String) {
        (findViewById(R.id.toolbar) as Toolbar).title = title
    }

    fun setToolbarText(@StringRes textRes:Int) {
        setToolbarText(getString(textRes))
    }
}