
## Introduction

Ever have trouble with remembering important dates and events?  Not sure if its an important job interview or a birthday party.  Well look no furthur the Calender App can help with:

- Adding important upcoming dates and events.
- Adding people who will be attending the event or a broad list.
- GPS tracker to notify attendees on arrival of important information about the event.
- Being able to send invites to events and coordinate on other peoples caledars.

Utilize your devices to create an upcoming event with others.  Add events, connect with others who are interested in the same activites.  Set alerts for incoming events in certain areas with GPS tracker.  

## Storyboard

![image](https://user-images.githubusercontent.com/77586024/169616850-032363ff-3545-4cc4-bed8-117f7c8bcba8.png)
https://www.fluidui.com/editor/live/preview/cF9ybHo3VFhEWG9zVjYzeWNSeVFmZ0hoRkNnT1RNeE5sdg==

### Functional Requirements 

### Requirement 100: Create Event 

#### Scenario 

As a person who host events, I want to be able to create an event to notify each attendee. 

#### Dependencies

Easy to plan and schedule.

#### Assumptions

Event is created in a smooth and reliable fashion so each person can be notified in the future.

#### Examples 

1.1

**Given** a Event Creation Screen is available to produce an event catalog to be uploaded.

**When** I click on the Create Event button. 

**Then** I should create a new event that will then create a page to add people to my New Event Page. 

1.2

**Given** a Event Creation Screen is available to produce an event catalog to be uploaded.

**When** I click on the Create Event Button.

**Then** I can view other peoples upcoming events along with my own and they may be organized together. 

1.3 

**Given** a Event Creation Screen is available to produce an event catalog to be uploaded.

**When** I click on the Create Event Button but upload the wrong info or location.

**Then** I can click on the edit option to fix picture for event, location, time, and alert message.

### Requirement 101: Add People to List

#### Scenario 

As an Event Organizer, I want to be able to add a list of people to my events so that I can plan accordingly.

#### Dependencies

Event list is produced for adding additional people. 

#### Assumptions

A list of people with different info to be applied to each person such as phone number or email. 

#### Examples

1.1

**Given** a list is provided. 

**When** After I add a new event or I am added to one myself.

**Then** I can update a list so that names of who will be attending are provided on the list.

1.2

**Given** a list is provided. 

**When** After I add a new event or I am added to one myself.

**Then** I can add certain specific info for each person such as an email or phone number for contact purposes. 

1.3

**Given** a list is provided.

**When** After I add a new event or I am added to one myself.

**Then** As an attendee myself, I can view the list for an upcoming event to see who is comming and other updates added to list. 

### Requirement 102: GPS Tracker access 

#### Scenario 

As someone searching for a job interview, I want to have a GPS Tracker to update me when im heading to a job interview to better prepare me.  

#### Dependencies 

GPS and Map are available for updating on events.

#### Assumptions 

GPS can send alerts to both parties the event planner and the attendee's.

#### Examples

1.1

**Given** A GPS Tracker is provided.

**When** A GPS Page is available.

**Then** On the GPS I should be able to see events within my current area. 

1.2

**Given** A GPS Tracker is provided.

**When** A GPS Page is available.

**Then** When accessing the GPS Page I can get alert notications on current events or upcoming ones. 

1.3 

**Given** A GPS Tracker is provided.

**When** A GPS Page is available.

**Then** If I dont add my current location then the GPS will not be available.

## Class Diagram
![image](https://user-images.githubusercontent.com/77586024/170885607-8f515471-662e-4b29-ab10-0027695e9050.png)


## Class Diagram Description
mainActivity: the main calendar screen used to view events

eventDetailsActivity: used to see details about an event clicked on from main activity

createEventActivity: where you create an event and set all of the nessesary data for the event object

Event: noun that represents an Event

mainViewModel: to manage data for the mainActivity 

createEventViewModel: to manage data for the createEventActivity 

IEventDAO: interface for room to persist event data

## Scrum Roles 
Dev/Ops - Cole Pownell

Front End Developer - Anish Selar

Integration Developer - Sam Gehrlich

## Weekly Meeting 

Weekends at 5 PM. Teams Meetings 
