package db;

import java.util.ArrayList;

import model.Event;
import model.Profile;

public class JDbManager implements DbManager {

	@Override
	public boolean authenticate(Profile p) {

		return false;
	}

	@Override
	public Event getEvent(Event e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Event> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
