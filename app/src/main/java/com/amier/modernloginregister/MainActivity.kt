package com.amier.modernloginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scrollingFrag = ScrollingFragmentDashboard()
        supportFragmentManager.beginTransaction()
            .add(R.id.root_container, scrollingFrag)
            .commitAllowingStateLoss()
    }
}