package com.example.calendarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Login Page for Calendar App

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        //Grab ID's from login_fragment.xml

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        //Click Listener for submit button

        loginBtn.setOnClickListener {

              //Sends User to the Main Activity Page After Login

              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)

              //Allows user to enter username and password

              var status = if(username.text.toString().equals("Test")
                  &&password.text.toString().equals("password")) "Logged In Successful" else "Login Failed"

            Toast.makeText(this,status,Toast.LENGTH_SHORT).show()

        }

    }

}



