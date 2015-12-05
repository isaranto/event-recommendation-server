package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import model.Event;
import model.Profile;

public class Mysql {
	static String url = "jdbc:mysql://localhost:3306/meetupDataset";
	static String user = "root";
	static String password = "12345";

	static Connection con = null;

	static ResultSet rs = null;

	static PreparedStatement pst = null;

	public static JSONArray get10Events() throws Exception {
		con = DriverManager.getConnection(url, user, password);
		pst = con.prepareStatement("SELECT * FROM events LIMIT 10");
		rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray get10Members() throws Exception {
		con = DriverManager.getConnection(url, user, password);
		pst = con.prepareStatement("SELECT * FROM members LIMIT 10");
		rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			try {
				//get an event and a profile from Db just for testing the methods
				Event event = new Gson().fromJson(get10Events().get(0).toString(), Event.class);
				Profile profile = new Gson().fromJson(get10Members().get(0).toString(), Profile.class);
				System.out.println(selectUserEvents(profile));
				System.out.println(selectUsersfromEvent(event));
			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Mysql.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);

			} finally {

				try {
					if (rs != null) {
						rs.close();
					}
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException ex) {
					Logger lgr = Logger.getLogger(Mysql.class.getName());
					lgr.log(Level.WARNING, ex.getMessage(), ex);
				}
			}
		} finally {
		}
	}

	public static JSONArray rsToJSONArray(ResultSet rs) throws Exception {
		JSONArray jsonArray = new JSONArray();
		while (rs.next()) {
			int rsCount = rs.getMetaData().getColumnCount();
			JSONObject obj = new JSONObject();
			for (int i = 0; i < rsCount; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i + 1).toLowerCase();
				Object columnValue = rs.getObject(i + 1);
				// if value in DB is null, then we set it to default value

				if (columnValue == null) {
					columnValue = null;
				}

				obj.put(columnName, columnValue);
			}
			jsonArray.put(obj);
		}
		return jsonArray;
	}

	public static JSONArray selectEvents(Event e) throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement("SELECT * FROM events WHERE urlname = ?");
		pst.setString(1, e.getUrlname());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray selectUserEvents(Profile p) throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		// PreparedStatement pst = con.prepareStatement("SELECT * FROM events
		// WHERE id = ?");
		PreparedStatement pst = con.prepareStatement(
				"SELECT events.* FROM members,attends,events WHERE members.id=? AND events.id=event_id AND response='yes' AND members.id=member_id;");
		pst.setInt(1, p.getId());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray selectUserRejectedEvents(Profile p) throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement(
				"SELECT events.* FROM members,attends,events WHERE members.id=? AND events.id=event_id AND response='no' AND members.id=member_id;");
		pst.setInt(1, p.getId());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray selectUsersfromEvent(Event e) throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement(
				"SELECT members.* FROM members,attends,events WHERE events.id=? AND events.id=event_id AND response='yes' AND members.id=member_id;");
		pst.setInt(1, e.getId());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	Statement st = null;

	public ArrayList<Event> getEvents(ResultSet rs) {
		ArrayList<Event> events = new ArrayList<Event>();
		return events;

	}
}
