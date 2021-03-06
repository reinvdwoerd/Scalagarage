package projectgroep.parkeergarage.logic.events;

import java.util.ArrayList;
import java.util.Arrays;

import projectgroep.parkeergarage.logic.ParkeerLogic;

public class Events {

	private ParkeerLogic model;
	private ArrayList<Event> events = new ArrayList<Event>();

	/**
	 * Constructor.
	 * 
	 * @param model The ParkeerLogic model instance.
	 */
	public Events(ParkeerLogic model) {
		this.model = model;
	}

	/**
	 * Add an instance of an Event object to the events ArrayList.
	 * 
	 * @param event The event to add
	 */
	public void addEvent(Event event) {
		if (!events.contains(event)) events.add(event);
	}

	/**
	 * Add a new Event to the events ArrayList.
	 * 
	 * @param name The name of the event.
	 * @param day The day that the event will take place.
	 * @param hour The hour that the event will start.
	 * @param minute The minute that the event will start.
	 * @param duration The total duration of the event.
	 * @param expectedVisitors The amount of visitors that are expected to show up at the event.
	 */
	public void addEvent(String name, int day, int hour, int minute, int[] duration, int expectedVisitors) {
		events.add(new Event(model, name, day, hour, minute, duration, expectedVisitors));				
	}

	/**
	 * Remove an Event from the events ArrayList.
	 * 
	 * @param event The event to remove.
	 */
	public void removeEvent(Event event) {
		if (events.contains(event)) events.remove(event);
	}

	/**
	 * Remove an Event from the events ArrayList by its name.
	 * 
	 * @param name The name of the event.
	 */
	public void removeEvent(String name) {
		events.forEach(event -> {
			if (event.getName().equals(name)) events.remove(event);
		});
	}

	/**
	 * Remove all of the Events from the events ArrayList.
	 */
	public void removeAll() {
		events.clear();
	}

	/**
	 * @return Returns an ArrayList with all of the events that start at a specific time.
	 * 
	 * @param startTime The time to use for the filter.
	 */
	public ArrayList<Event> getEventsByStartTime(int[] startTime) {
		ArrayList<Event> toReturn = new ArrayList<Event>();
		
		for (Event event : events) {
			if (Arrays.equals(startTime, event.getStartTime())) toReturn.add(event);
		}
		
		return toReturn;
	}
	
	public ArrayList<Event> getRunningEvents(int[] currentTime) {
		ArrayList<Event> toReturn = new ArrayList<Event>();
		
		for (Event event : events) {
			if (event.isStarted()) toReturn.add(event);
		}
		
		return toReturn;	
	}
	
//	public int getTotalVisitorCount() {
//		ArrayList<Event> runningEvents = getRunningEvents(model.getCurrentTime());
//		int totalVisitors = 0;
//		
//		for (Event event : runningEvents) {
//			totalVisitors += event.getNumberOfCars();
//		}
//		
//		return totalVisitors;
//	}
//	
	/**
	 * @return Returns all of the Events listed in the events ArrayList.
	 */
	public ArrayList<Event> getEvents() {
		return events;
	}

	/**
	 * Set the events ArrayList.
	 * 
	 * @param events The ArrayList of Event objects that the events ArrayList should be set to.
	 */
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

}
