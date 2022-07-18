package com.example.calendarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.reflect.Type

class LoginPage : AppCompatActivity() {

    lateinit var handler:DatabaseHelper
    private val registrationLayout = findViewById<RelativeLayout>(R.id.registration_layout)
    private val homeLogin = findViewById<LinearLayout>(R.id.home_login)
    private val registerButton = findViewById<Button>(R.id.register_button)
    private val saveUserButton = findViewById<Button>(R.id.save_newUsername)
    private val newUsername = findViewById<EditText>(R.id.new_username)
    private val newPassword = findViewById<EditText>(R.id.new_password)

    override fun onCreate(savedInstanceState: Bundle?) {
        //Login Page for Calendar App

        //Grab ID's from login_fragment.xml

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        handler = DatabaseHelper(this)

        showHomeLogin()

        registerButton.setOnClickListener{
            showRegistration()
        }

        saveUserButton.setOnClickListener{

            handler.insertUserData(newUsername.text.toString(), newPassword.text.toString())
            showHomeLogin()
        }

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

    private fun showRegistration() {

        registrationLayout.visibility=View.VISIBLE
        homeLogin.visibility=View.GONE
    }

    private fun showHomeLogin() {
        homeLogin.visibility=View.VISIBLE
        registrationLayout.visibility=View.GONE
    }

}


