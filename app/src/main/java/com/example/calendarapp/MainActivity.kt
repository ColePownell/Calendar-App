package com.example.calendarapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        var indexList: ArrayList<Int> = arrayListOf()
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)
        login = findViewById(R.id.loginBTN)
        //create string from json file
        val text = resources.openRawResource(R.raw.event)
            .bufferedReader().use { it.readText() }
        // changes date above calendar when date is clicked,
        calendarView.setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.setText(Date)
                    //find index of date from json string
                    indexList.clear()
                    var index = 0
                    while (index >= 0)
                    {
                    index = findindex(text, Date,index+1)
                        indexList.add(index)
                        println(index)
                    }
                })





        }

    fun findindex(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
        val matchIndex = inputString.indexOf(whatToFind, startIndex)
        return matchIndex
    }
    }


