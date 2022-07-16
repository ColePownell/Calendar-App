package com.example.calendarapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dateTV: TextView
    private lateinit var calendarView: CalendarView

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
                    // in which we are adding all the variables in it.
                    val date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.text = date


//inital setup for reading json string
            indexList.clear()
            var index = 0
            while (index >= 0)
                    {
                    index = findIndex(text, date,index+1)
                    indexList.add(index)
                    println(index)
                    }
                })
        }

    // finds any json events with the specified date
    private fun findIndex(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
        return inputString.indexOf(whatToFind, startIndex)
    }
}


