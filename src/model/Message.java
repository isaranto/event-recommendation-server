package model;

import java.util.ArrayList;

public class Message {

	private String action;
	private ArrayList<Event> events;
	private ArrayList<Profile> profiles;
	private ArrayList<Category> categories;
	private boolean ack;

	public Message(String action, boolean ack) {
		this.action = action;
		this.ack = ack;
	}

	public boolean getAck() {
		return this.ack;
	}

	public String getAction() {
		return this.action;
	}

	public ArrayList<Category> getCategories() {
		return this.categories;
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public ArrayList<Profile> getProfiles() {
		return this.profiles;
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
