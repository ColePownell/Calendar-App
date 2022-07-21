package com.example.calendarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentMain : Fragment(), View.OnClickListener{

    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView

    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
return inflater.inflate(R.layout.main_fragment,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        var indexList: ArrayList<Int> = arrayListOf()
        //create string from json file
        val text = resources.openRawResource(R.raw.event)
            .bufferedReader().use { it.readText() }
        view.findViewById<Button>(R.id.loginBTN).setOnClickListener(this)
        view.findViewById<Button>(R.id.addEventBTN).setOnClickListener(this)
        view.findViewById<CalendarView>(R.id.calendarView)
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view2, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the cariables in it.
                    val date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    view.findViewById<TextView>(R.id.idTVDate).text = date

//inital setup for reading json string
                    indexList.clear()
                    var index = 0
                    while (index >= 0)
                    {
                        index = findindex(text, date,index+1)
                        indexList.add(index)
                        println(index)
                    }
                })
    }



    fun findindex(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
        val matchIndex = inputString.indexOf(whatToFind, startIndex)
        return matchIndex
    }
    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.loginBTN -> navController!!.navigate(R.id.action_navigation_home_to_login)
            R.id.addEventBTN -> navController!!.navigate(R.id.action_navigation_home_to_newEventPage)
        }
        }
}