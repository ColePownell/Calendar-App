package com.example.calendarapp.dto
//types can be changed as needed
/**
 * * A data class Event is noun class Data Transfer Object.
 * @property name the name for every Event : String
 * @property time the time for every Event : String
 * @property people the List of people for every Event : String
 * @property location the frequency for every Event : String
 */
data class Event(val name: String, val time: String, val people: List<String>, val location: String){
    /**
     * Contains all the methods for data class Event
     */

    /**
     * This returns the Event's name, time, people attending and location as a string.
     * Helps in debugging errors and acts as a printable placeholder
     *
     * @return: name, time, people attending and location as a string concatenated
     */
    override fun toString(): String {
        return name.plus(" ").plus(time).plus(people).plus(location)
    }
}