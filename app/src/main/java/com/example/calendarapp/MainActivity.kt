package com.example.calendarapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calendarapp.ui.theme.CalendarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val username = findViewById<EditText>(R.id.username_et)
        val password = findViewById<EditText>(R.id.password_et)
        val loginButton = findViewById<Button>(R.id.login_btn)

        loginButton.setOnClickListener {

           var status = if (username.text.toString().equals("username")
                &&password.text.toString().equals("password")) "Logged In Successfully"
            else "Log In Failed"

            Toast.makeText(this,status,Toast.LENGTH_SHORT).show()

        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalendarAppTheme {
        Greeting("Android")
    }
}