package schedulers;

import model.Message;
import model.Profile;
import tasks.ConnectionInfo;
import util.GlobalManagers;

import com.google.gson.Gson;

public class AuthQueryScheduler {

	public static Profile dbMethodMockUp(Profile p) {
		/*
		 * TODO: remove and link properly with the DBManager.
		 */
		if ((p.getEmail().equals("admin@mail.com"))
				&& (p.getPassword().equals("admin"))) {
			Profile mock = new Profile();
			mock.setId(0);
			return mock;
		} else {
			return null;
		}
	}

	public static void handleAuthentication(Message m, String uID) {
		if (!messageIsValid(m)) {
			Message response = new Message("invalid-request", false);
			GlobalManagers.taskManager.sendMessageToNetwork(
					new Gson().toJson(response), uID);
		}
		Profile existingProfile = dbMethodMockUp(m.getProfiles().get(0));
		if (existingProfile == null) {
			Message response = new Message("wrong-credentials", false);
			GlobalManagers.taskManager.sendMessageToNetwork(
					new Gson().toJson(response), uID);
		} else {
			ConnectionInfo con = new ConnectionInfo(uID,
					existingProfile.getId(), true);
			GlobalManagers.taskManager.updateInfoMap(uID, con);
			m.setAck(true);
			GlobalManagers.taskManager.sendMessageToNetwork(
					new Gson().toJson(m), uID);
		}
	}

	public static boolean messageIsValid(Message m) {
		try {
			boolean ack = (m.getAck() == false);
			boolean profile = (m.getProfiles().size() == 1);
			boolean params = ((m.getProfiles().get(0).getEmail() != null) && (m
					.getProfiles().get(0).getPassword() != null));
			boolean other = ((m.getEvents() == null) && (m.getCategories() == null));
			return ack && profile && params && other;
		} catch (Exception e) {
			return false;
		}
	}
}
