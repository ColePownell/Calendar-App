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
import org.json.JSONException
import org.json.JSONObject
import java.io.*

class editPage : Fragment(), View.OnClickListener{
    private var eventname: String? = null
    private var eventtime: String? = null
    private var eventdate: String? = null
    private var eventlocation: String? = null
    var navController: NavController? = null
    var tempeventname = ""
    var tempeventdate =""
    val json = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set text fields to arguments
        eventname = requireArguments().getString("eventname")
        eventtime = requireArguments().getString("eventtime")
        eventdate = requireArguments().getString("eventdate")
        eventlocation = requireArguments().getString("eventlocation")
    }

//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.already_created_event_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.etName).text = eventname
        view.findViewById<TextView>(R.id.etTime).text = eventtime
        view.findViewById<TextView>(R.id.etDate).text = eventdate
        view.findViewById<TextView>(R.id.etLocation).text = eventlocation
        tempeventdate = view.findViewById<TextView>(R.id.etDate).text.toString()
        tempeventname = view.findViewById<TextView>(R.id.etName).text.toString()

        view.findViewById<Button>(R.id.deleteBTN).setOnClickListener{
            try {
                val file = File(requireContext().filesDir, "event.json")
                var flag = 0
                val fileReader = FileReader(file)
                val bufferedReader = BufferedReader(fileReader)
                val stringBuilder = StringBuilder()
                var line = bufferedReader.readLine()
                while (line != null) {
                    if(line.contains(tempeventname) && line.contains(tempeventdate))
                    {
                        line = bufferedReader.readLine()
                    }
                    else {
                        stringBuilder.append(line).append("\n")
                        line = bufferedReader.readLine()
                        flag++
                    }
                }
                bufferedReader.close()


                val fileWriter = FileWriter(file)
                val bufferedWriter = BufferedWriter(fileWriter)
                bufferedWriter.write(stringBuilder.toString())
                bufferedWriter.close()




    //                    PrintWriter(FileWriter(path, true))
    //                        .use { it.write(json.toString()) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        navController!!.navigate(R.id.action_editPage_to_navigation_home)}

        view.findViewById<Button>(R.id.editBTN).setOnClickListener{
            try {
                json.put("name", view.findViewById<TextView>(R.id.etName).text)
                json.put("date", view.findViewById<TextView>(R.id.etDate).text)
                json.put("time", view.findViewById<TextView>(R.id.etTime).text)
                json.put("location", view.findViewById<TextView>(R.id.etLocation).text)
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
                    if(line.contains(tempeventname) && line.contains(tempeventdate))
                    {
                        stringBuilder.append(json.toString()+",").append("\n")
                        line = bufferedReader.readLine()
                        flag++
                    }
                    else {
                        stringBuilder.append(line).append("\n")
                        line = bufferedReader.readLine()
                        flag++
                    }
                }
                bufferedReader.close()


                val fileWriter = FileWriter(file)
                val bufferedWriter = BufferedWriter(fileWriter)
                bufferedWriter.write(stringBuilder.toString())
                bufferedWriter.close()




//                    PrintWriter(FileWriter(path, true))
//                        .use { it.write(json.toString()) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            navController!!.navigate(R.id.action_editPage_to_navigation_home)
        }

    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {

        }
    }
}