package com.example.calendarapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.lang.reflect.Type

class LoginPage : Fragment(), View.OnClickListener {


    lateinit var handler:DatabaseHelper
//    private val registrationLayout = findViewById<RelativeLayout>(R.id.registration_layout)
//    private val homeLogin = findViewById<LinearLayout>(R.id.home_login)
//    private val registerButton = findViewById<Button>(R.id.register_button)
//    private val saveUserButton = findViewById<Button>(R.id.save_newUsername)
//    private val newUsername = findViewById<EditText>(R.id.new_username)
//    private val newPassword = findViewById<EditText>(R.id.new_password)

    override fun onCreate(savedInstanceState: Bundle?) {
        // Login Page for Calendar App
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val registrationLayout = view.findViewById<RelativeLayout>(R.id.registration_layout)
        val homeLogin = view.findViewById<LinearLayout>(R.id.home_login)
        val registerButton = view.findViewById<Button>(R.id.register_button)
        val saveUserButton = view.findViewById<Button>(R.id.save_newUsername)
        val newUsername = view.findViewById<EditText>(R.id.new_username)
        val newPassword = view.findViewById<EditText>(R.id.new_password)
        val loginBtn =  view.findViewById<Button>(R.id.loginBTN)
        val username =  view.findViewById<EditText>(R.id.username)
        val password =  view.findViewById<EditText>(R.id.password)




        handler = DatabaseHelper(requireContext())

        showHomeLogin(view)


        registerButton.setOnClickListener{

            showRegistration(view)
        }

        saveUserButton.setOnClickListener {

            handler.insertUserData(newUsername.text.toString(), newPassword.text.toString())
            showHomeLogin(view)
        }


        //Click Listener for submit button


        view.findViewById<Button>(R.id.loginBtn).setOnClickListener {

            if (handler.userPresent(username.text.toString(), password.text.toString()))
                Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(
                    requireContext(),
                    "Login failed Incorrect Username or Password",
                    Toast.LENGTH_SHORT
                ).show()



        }
    }


    private fun showRegistration(view: View) {

        val registrationLayout = view.findViewById<RelativeLayout>(R.id.registration_layout)
        val homeLogin = view.findViewById<LinearLayout>(R.id.home_login)
        registrationLayout.visibility=View.VISIBLE
        homeLogin.visibility=View.GONE
    }

    private fun showHomeLogin(view: View) {
        val registrationLayout = view.findViewById<RelativeLayout>(R.id.registration_layout)
        val homeLogin = view.findViewById<LinearLayout>(R.id.home_login)
        homeLogin.visibility=View.VISIBLE
        registrationLayout.visibility=View.GONE

    }
    override fun onClick(v: View?) {
        when(v!!.id) {

        }
        }
}


