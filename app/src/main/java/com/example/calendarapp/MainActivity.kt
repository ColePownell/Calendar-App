package com.example.calendarapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        val indexList: ArrayList<Int> = arrayListOf()
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)
        //create string from json file
        val text = resources.openRawResource(R.raw.event)
            .bufferedReader().use { it.readText() }

        calendarView
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the cariables in it.
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.setText(Date)


//inital setup for reading json string
            indexList.clear()
            var index = 0
            while (index >= 0)
                    {
                    index = findindex(text, Date,index + 1)
                    indexList.add(index)
                    println(index)
                    }
                })
        }
// finds any json events with the specified date
    fun findindex(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
        val matchIndex = inputString.indexOf(whatToFind, startIndex)
        return matchIndex
    }
    }


