package com.example.calendarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.reflect.Type

class LoginPage : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        //Login Page for Calendar App

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        handler = DatabaseHelper(this)

        showHomeLogin()

        register_button.setOnClickListener{
            showRegistration()
        }

        saveUserButton.setOnClickListener{

            handler.insertUserData(newUsername.text.toString(), newPassword.text.toString())
            showHomeLogin()
        }

        LoginSubmitListner()
    }

    fun LoginSubmitListner()
    {
        //Grab ID's from login_fragment.xml
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        //Click Listener for submit button
        loginBtn.setOnClickListener {


            if (handler.userPresent(username.text.toString(), password.text.toString()))
                Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Login failed Incorrect Username or Password",Toast.LENGTH_SHORT).show()

            //Sends User to the Main Activity Page After Login

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

    val registration_layout = findViewById<RelativeLayout>(R.id.registration_layout)
    val home_login = findViewById<LinearLayout>(R.id.home_login)
    val register_button = findViewById<Button>(R.id.register_button)
    val saveUserButton = findViewById<Button>(R.id.save_newUsername)
    val newUsername = findViewById<EditText>(R.id.new_username)
    val newPassword = findViewById<EditText>(R.id.new_password)


    private fun showRegistration() {

        registration_layout.visibility=View.VISIBLE
        home_login.visibility=View.GONE
    }

    private fun showHomeLogin() {
        home_login.visibility=View.VISIBLE
        registration_layout.visibility=View.GONE
    }


}


