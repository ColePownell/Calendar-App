package com.example.calendarapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.dto.Event


class CustomAdapter(private val mList: List<Event>, val clickListener: (Event, Int) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val event = mList[position]

        // sets the image to the imageview if needed
//        holder.imageView.setImageResource(R.drawable.ic_baseline_folder_24)

        // sets the text to the textview from our Event class
        holder.textView.text = event.name
        holder.textView.setOnClickListener { clickListener(event, position) }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }




    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)


    }
}