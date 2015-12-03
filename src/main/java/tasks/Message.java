package tasks;

import java.util.ArrayList;

import model.Category;
import model.Event;
import model.Profile;

public class Message {

	String action;
	ArrayList<Event> events;
	ArrayList<Profile> profiles;
	ArrayList<Category> categories;
	boolean ack;

	public Message(String action, boolean ack) {
		this.action = action;
		this.ack = ack;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public void setProfiles(ArrayList<Profile> profiles) {
		this.profiles = profiles;
	}
}
