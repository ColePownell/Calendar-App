package com.example.calendarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.json.JSONException
import org.json.JSONObject
import java.io.*


class NewEventPage : Fragment(), View.OnClickListener{
val path = File("event.json")
//    val path2 = File(resources.openRawResource(R.raw.event).)
//    resources.openRawResource(R.raw.event)
//    lateinit var dateTV: TextView

    var navController: NavController? = null
    val json = JSONObject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.new_event_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.createBTN).setOnClickListener()
        {
            if (view.findViewById<TextView>(R.id.tfdate).text.isNotEmpty() ||
                view.findViewById<TextView>(R.id.tftime).text.isNotEmpty() ||
                view.findViewById<TextView>(R.id.tflocation).text.isNotEmpty() ||
                view.findViewById<TextView>(R.id.tfeventname).text.isNotEmpty()
            ) {
                try {
                    json.put("name", view.findViewById<TextView>(R.id.tfeventname).text)
                    json.put("date", view.findViewById<TextView>(R.id.tfdate).text)
                    json.put("time", view.findViewById<TextView>(R.id.tftime).text)
                    json.put("location", view.findViewById<TextView>(R.id.tflocation).text)
                } catch (e: JSONException) {
                    println("path fail")
                }
                try {
                    val file = File(requireContext().filesDir, "event.json")
                    var flag = 0
                    val fileReader = FileReader(file)
                    val bufferedReader = BufferedReader(fileReader)
                    val stringBuilder = StringBuilder()
                    var line = bufferedReader.readLine()
                    while (line != null) {
                        if(flag ==1)
                        {
                            stringBuilder.append(json.toString()+",").append("\n")
                        }
                        stringBuilder.append(line).append("\n")
                        line = bufferedReader.readLine()
                        flag++
                    }
                    bufferedReader.close()

                    val fileWriter = FileWriter(file)
                    val bufferedWriter = BufferedWriter(fileWriter)
                    bufferedWriter.write(stringBuilder.toString())
                    bufferedWriter.close()

                    navController!!.navigate(R.id.action_newEventPage_to_navigation_home)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(requireContext(), "Please fill text fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {


        }
    }
}