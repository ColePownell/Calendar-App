package com.example.calendarapp

import android.os.Bundle
import android.util.Log
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.dto.Event
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString


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
//        println(text)
        val EventList = Json.decodeFromString<List<Event>>(text)

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
                    val dateeventlist = ArrayList<Event>()
                    // set this date in TextView for Display
                    view.findViewById<TextView>(R.id.idTVDate).text = date
                    for(Event in EventList)
                    {
                        if(Event.date.contains(date))
                        { dateeventlist.add(Event)
                        }
                    }
                    val recyclerview = view.findViewById<RecyclerView>(R.id.recycleview)
                    recyclerview.layoutManager = LinearLayoutManager(requireContext())
                    val adapter = CustomAdapter(dateeventlist){
                        navController!!.navigate(R.id.action_navigation_home_to_eventDetailsPage)
                    }
                    recyclerview.adapter = adapter



                })


        // getting the recyclerview by its id
//        val recyclerview = view.findViewById<RecyclerView>(R.id.recycleview)
//
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = LinearLayoutManager(requireContext())
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<Event>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            data.add(Event("testname", "test date", "testtime", "testdate"))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter
    }




    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.loginBTN -> navController!!.navigate(R.id.action_navigation_home_to_login)
            R.id.addEventBTN -> navController!!.navigate(R.id.action_navigation_home_to_newEventPage)
        }
        }
}