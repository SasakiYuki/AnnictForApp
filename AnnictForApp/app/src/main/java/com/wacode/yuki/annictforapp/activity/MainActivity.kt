package com.wacode.yuki.annictforapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wacode.yuki.annictforapp.activity.OAuthActivity
import com.wacode.yuki.annictforapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, OAuthActivity::class.java))
    }
}
