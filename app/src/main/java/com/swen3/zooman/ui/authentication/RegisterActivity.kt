package com.swen3.zooman.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.swen3.zooman.Customer
import com.swen3.zooman.ui.MainActivity
import com.swen3.zooman.R
import com.swen3.zooman.database.DataBaseHandler
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnLogRegister.setOnClickListener {
            onBackPressed()
        }

        val context =this


        val btnRegister = findViewById<Button>(R.id.button)
        btnRegister.setOnClickListener {
            if(electronic_mail.text.toString().isNotEmpty() && name.text.toString().isNotEmpty() &&
                passcode.text.toString().isNotEmpty()
            ) {
                val customer= Customer(electronic_mail.text.toString(), name.text.toString(), passcode.text.toString())

                val dB=DataBaseHandler(context)

                dB.insertData(customer)


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(context, "Please Fill All Data",Toast.LENGTH_LONG)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

}
