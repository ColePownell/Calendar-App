package com.example.calendarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.dto.Event
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentMain : Fragment(), View.OnClickListener{



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

        //sample data on first launch
        val inputStream = context?.assets?.open("event.json")
        val inittext = inputStream?.bufferedReader().use { it!!.readText() }
        var text = ""
        val file = File(requireContext().filesDir, "event.json")
        if(file.exists()) {
            //gets data from an existing json file
            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val stringBuilder = StringBuilder()
            var line = bufferedReader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            text = "$stringBuilder"
        }else
        {
            //creates an event json file on first open and puts in sample events
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(inittext)
            bufferedWriter.close()
            //now grabs data from created file
            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val stringBuilder = StringBuilder()
            var line = bufferedReader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            text = "$stringBuilder"
        }

        // create list of events from json string
        val EventList = Json.decodeFromString<List<Event>>(text)

        view.findViewById<Button>(R.id.loginBTN).setOnClickListener(this)
        view.findViewById<Button>(R.id.addEventBTN).setOnClickListener(this)
        view.findViewById<CalendarView>(R.id.calendarView)
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view2, year, month, dayOfMonth ->
// set clicklistener for the change date, changes recycleview and textview for date
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
                    //navigates and sends arguments to event details
                    val adapter = CustomAdapter(dateeventlist){ event: Event, position: Int ->
                        val bundle = bundleOf("eventdate" to dateeventlist[position].date,
                            "eventtime" to dateeventlist[position].time,
                            "eventlocation" to dateeventlist[position].location,
                            "eventname" to dateeventlist[position].name)
                        navController!!.navigate(R.id.action_navigation_home_to_eventDetailsPage, bundle)
                    }
                    recyclerview.adapter = adapter



                })


    }


    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.loginBTN -> navController!!.navigate(R.id.action_navigation_home_to_login)
            R.id.addEventBTN -> navController!!.navigate(R.id.action_navigation_home_to_newEventPage)
        }
        }
}