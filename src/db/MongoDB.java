package db;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import model.Event;
import model.Profile;

public class MongoDB {
	static MongoClient mongoClient = new MongoClient("104.223.64.18", 27017);

	static MongoDatabase db = mongoClient.getDatabase("event-server");
	// Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	// mongoLogger.setLevel(Level.SEVERE);

	public static ArrayList<Event> getEvents() {
		ArrayList<Event> list = new ArrayList<Event>();
		FindIterable<Document> rs = db.getCollection("events").find(new Document("urlname", "Test-Event"));
		rs.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				list.add(new Gson().fromJson(document.toJson().toString(), Event.class));
			}
		});
		return list;
	}

	public static ArrayList<Profile> getProfiles() {
		ArrayList<Profile> list = new ArrayList<Profile>();
		FindIterable<Document> rs = db.getCollection("members").find(new Document("city", "New York"));
		rs.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				list.add(new Gson().fromJson(document.toJson().toString(), Profile.class));
			}
		});
		return list;
	}

	public static void main(String args[]) {

		try {

			// System.out.println(getEvents().get(0).toString());
			System.out.println(getProfiles().get(0));

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}