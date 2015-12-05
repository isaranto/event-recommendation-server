package tasks;

import model.Message;
import schedulers.GenericQueryScheduler;
import util.GlobalManagers;
import util.ProjectVariables;

import com.google.gson.Gson;

public class JTaskManager implements TaskManager {

	private ConnectionInfoHashMap infoMap;

	public JTaskManager() {
		infoMap = new ConnectionInfoHashMap(
				ProjectVariables.getIntValue("max_num_of_connections"));
	}

	@Override
	public void handleMessageFromNetwork(String m, String uID) {
		try {
			Message msg = new Gson().fromJson(m, Message.class);
			if (!infoMap.containsConnection(uID)) {
				infoMap.addConnection(new ConnectionInfo(uID));
			}
			if (!MessageInterpreter.messageIsValid(msg)) {
				Message response = new Message("invalid-request", false);
				sendMessageToNetwork(new Gson().toJson(response), uID);
				return;
			}
			if ((MessageInterpreter.messageRequiresAuth(msg))
					&& (!infoMap.get(uID).isAuthenticated())) {
				Message response = new Message("unauthorised-access", false);
				sendMessageToNetwork(new Gson().toJson(response), uID);
				return;
			}
			GenericQueryScheduler.handleGenericMessage(msg, uID);
		} catch (Exception e) {
			Message response = new Message("invalid-request", false);
			sendMessageToNetwork(new Gson().toJson(response), uID);
		}

	}

	@Override
	public void sendMessageToNetwork(String msg, String uID) {
		GlobalManagers.networkManager.sendMessageToClient(msg, uID);
	}

	@Override
	public void updateInfoMap(String uID, ConnectionInfo con) {
		try {
			ConnectionInfo obsolete = infoMap.get(uID);
			obsolete.setAuthenticated(con.isAuthenticated());
			obsolete.setAppUID(con.getAppUID());
		} catch (NullPointerException n) {
			// do nothing;
		}
	}
}
