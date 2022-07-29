package com.example.calendarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calendarapp.dto.Event


class EventDetailsPage : Fragment(), View.OnClickListener{
private var eventname: String? = null
    private var eventtime: String? = null
    private var eventdate: String? = null
    private var eventlocation: String? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set text fields to arguments
        eventname = requireArguments().getString("eventname")
        eventtime = requireArguments().getString("eventtime")
        eventdate = requireArguments().getString("eventdate")
        eventlocation = requireArguments().getString("eventlocation")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.event_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.eventName).text = eventname
        view.findViewById<TextView>(R.id.eventTime).text = eventtime
        view.findViewById<TextView>(R.id.eventDate).text = eventdate
        view.findViewById<TextView>(R.id.eventLocation).text = eventlocation
        view.findViewById<Button>(R.id.sendEditBTN).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {
            R.id.sendEditBTN -> {
                navController!!.navigate(R.id.action_eventDetailsPage_to_editPage)
            }

        }
    }
}