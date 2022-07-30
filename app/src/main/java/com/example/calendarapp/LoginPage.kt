package com.example.calendarapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class LoginPage : Fragment(), View.OnClickListener {


    lateinit var handler:DatabaseHelper
var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val registerButton = view.findViewById<Button>(R.id.register_button)
        val saveUserButton = view.findViewById<Button>(R.id.save_newUsername)
        val newUsername = view.findViewById<EditText>(R.id.new_username)
        val newPassword = view.findViewById<EditText>(R.id.new_password)
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
            {
                Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
                navController!!.navigate(R.id.action_login_to_navigation_home)
            }
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

        }
}


