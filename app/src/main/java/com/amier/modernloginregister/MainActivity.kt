package com.amier.modernloginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scrollingFrag = ScrollingFragmentDashboard()
        val ticketMstrFrag = TicketMasterFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.root_container, scrollingFrag)
            .commitAllowingStateLoss()

        val btnChangeFrag = findViewById<Button>(R.id.change_frag)
        btnChangeFrag.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.root_container, ticketMstrFrag)
                .commitAllowingStateLoss()

        }
    }
}