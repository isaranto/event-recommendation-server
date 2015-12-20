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

public class JDbManager implements DbManager {

	static String url = "jdbc:mysql://localhost:3306/meetupDataset";
	static String user = "root";
	static String password = "12345";

	static Connection con = null;

	static ResultSet rs = null;

	static PreparedStatement pst = null;

	public static void addEvent(Event e) throws Exception {
		// first check if the event already exists
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO events(urlname,time,utc_offset,lat,lon) VALUES (?,?,?,?,?);");
		if (e.getUrlname().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(1, e.getUrlname());
		}
		if (e.getTime() == null) {
			pst.setNull(2, java.sql.Types.BIGINT);
		} else {
			pst.setLong(2, e.getTime());
		}

		if (e.getUtc_offset() == null) {
			pst.setNull(2, java.sql.Types.INTEGER);
		} else {
			pst.setInt(3, e.getUtc_offset());
		}

		if (e.getLat() == null) {
			pst.setNull(2, java.sql.Types.DOUBLE);
		} else {
			pst.setDouble(4, e.getLat());
		}

		if (e.getLon() == null) {
			pst.setNull(2, java.sql.Types.DOUBLE);
		} else {
			pst.setDouble(5, e.getLon());
		}
		pst.executeUpdate();

	}

	public static void addProfile(Profile p) throws Exception {
		// first check if the event already exists
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement(
				"INSERT INTO members(id,name,joined,bio,country,city,state,email,gender,hometown,lang,link,facebook,flickr,tumblr,twitter,linkedin,birth_day,birth_month,birth_year,lat,lon,fb_name,fb_gender) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		pst.setInt(1, p.getId());
		if (p.getName().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(2, p.getName());
		}
		if (p.getJoined() == null) {
			pst.setNull(2, java.sql.Types.BIGINT);
		} else {
			pst.setLong(3, p.getJoined());
		}
		if (p.getBio().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(4, p.getBio());
		}
		if (p.getCountry().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(5, p.getCountry());
		}
		if (p.getCity().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(6, p.getCity());
		}

		if (p.getState().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(7, p.getState());
		}

		if (p.getEmail().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(8, p.getEmail());
		}
		if (p.getGender().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(9, p.getGender());
		}

		if (p.getHometown().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(10, p.getHometown());
		}

		if (p.getlang().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(11, p.getlang());
		}

		if (p.getLink().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(12, p.getLink());
		}
		if (p.getFacebook().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(13, p.getFacebook());

		}
		if (p.getFlickr().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(14, p.getFlickr());
		}
		if (p.getTumblr().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(15, p.getTumblr());
		}
		if (p.getTwitter().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(16, p.getTwitter());
		}
		if (p.getLinkedin().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(17, p.getLinkedin());
		}
		if (p.getBirth_day() == null) {
			pst.setNull(2, java.sql.Types.INTEGER);
		} else {
			pst.setInt(18, p.getBirth_day());
		}
		if (p.getBirth_month() == null) {
			pst.setNull(2, java.sql.Types.INTEGER);
		} else {
			pst.setInt(19, p.getBirth_month());

		}
		if (p.getBirth_year() == null) {
			pst.setNull(2, java.sql.Types.INTEGER);
		} else {
			pst.setInt(20, p.getBirth_year());

		}
		if (p.getLat() == null) {
			pst.setNull(2, java.sql.Types.DOUBLE);
		} else {
			pst.setDouble(21, p.getLat());

		}
		if (p.getLon() == null) {
			pst.setNull(2, java.sql.Types.DOUBLE);
		} else {
			pst.setDouble(22, p.getLon());
		}
		if (p.getFb_name().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(23, p.getFb_name());
		}
		if (p.getFb_gender().isEmpty()) {
			pst.setNull(2, java.sql.Types.VARCHAR);
		} else {
			pst.setString(24, p.getFb_gender());
		}
		pst.executeUpdate();

	}

	// get 10 events for development purposes
	public static JSONArray get10Events() throws Exception {
		con = DriverManager.getConnection(url, user, password);
		pst = con.prepareStatement("SELECT * FROM events LIMIT 10");
		rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	// get events with urlname = parameter given

	// get 10 profiles for development purposes
	public static JSONArray get10Members() throws Exception {
		con = DriverManager.getConnection(url, user, password);
		pst = con.prepareStatement("SELECT * FROM members LIMIT 10");
		rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray getEvent(Event e) throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement("SELECT * FROM events WHERE urlname = ?");
		pst.setString(1, e.getUrlname());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static JSONArray getProfile(Profile p) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		pst = con.prepareStatement("SELECT * FROM members WHERE id=?");
		// pst = con.prepareStatement("SELECT
		// id,name,DATE_FORMAT(FROM_UNIXTIME(`joined`), '%e %b %Y') AS
		// 'joined',bio,country,city,state,email,gender,hometown,lang,link,facebook,flickr,tumblr,twitter,linkedin,birth_day,birth_month,birth_year,lat,lon,fb_name,fb_gender
		// FROM members WHERE id=?");
		pst.setInt(1, p.getId());
		ResultSet rs = pst.executeQuery();
		return rsToJSONArray(rs);

	}

	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			try {
				// get an event and a profile from Db just for testing the
				// methods
				Event event = new Gson().fromJson(get10Events().get(0).toString(), Event.class);
				Profile profile = new Gson().fromJson(get10Members().get(0).toString(), Profile.class);
				Event test1 = new Gson().fromJson(get10Events().get(1).toString(), Event.class);
				test1.setId(12345);
				test1.setUrlname("TESTME");
				// addEvent(test1);
				Profile test2 = new Gson().fromJson(get10Members().get(2).toString(), Profile.class);
				// System.out.println(selectUserEvents(profile));
				// System.out.println(selectUsersfromEvent(event));
				// System.out.println(test1.toString());

				System.out.println(test2.toString());
				test2.setName("OBVIOUS");
				test2.setId(-10);
				addProfile(test2);
				System.out.println(test2.toString());
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

	// get events that The selected User is NOT going to attend

	// get events that The selected User is going to attend
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

	// get the list of the users that are going to attend the event

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

	// authentication is done here

	Statement st = null;

	public boolean authenticate(Profile p) {

		return true;

	}

	public ArrayList<Event> getEvents(ResultSet rs) {
		ArrayList<Event> events = new ArrayList<Event>();
		return events;

	}

}
