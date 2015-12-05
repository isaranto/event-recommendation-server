package db;

import java.util.ArrayList;

import model.Event;
import model.Profile;

public interface DbManager {
	public boolean authenticate(Profile p);

	public Event getEvent(Event e);

	public ArrayList<Event> getEvents();
}
