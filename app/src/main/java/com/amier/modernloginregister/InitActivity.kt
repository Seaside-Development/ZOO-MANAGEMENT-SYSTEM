package com.amier.modernloginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
        /*if (isLoggedIn){
            // start main activity
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        } else  {
            //start register activity
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent);
        }*/
    }
}