package com.swen3.zooman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swen3.zooman.R

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