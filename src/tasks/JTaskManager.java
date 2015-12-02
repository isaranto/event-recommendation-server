package tasks;

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
	public void handleMessageFromNetwork(String msg, String uID) {

		if (!infoMap.containsConnection(uID)) {
			ConnectionInfo con = new ConnectionInfo(uID);
			infoMap.addConnection(con);
		}

		Message m = new Message("action-verification", true);
		sendMessageToNetwork(new Gson().toJson(m), uID);
	}

	@Override
	public void sendMessageToNetwork(String msg, String uID) {
		GlobalManagers.networkManager.sendMessageToClient(msg, uID);
	}
}
