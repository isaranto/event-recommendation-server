package tasks;

import model.Message;
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
		/*
		 * If everything so far is ok (message is valid) we push the message to
		 * another entity responsible for handling the queries (Scheduler). The
		 * Scheduler discerns simple from composite tasks and assigns the
		 * execution to the DBManager or the Map-Reduce framework. As soon as
		 * the task is finished the Scheduler contacts another entity called
		 * ResponseManager. The ResponseManager most usually appends the result
		 * (boolean or data-collection) to a new Message and just pushes it back
		 * to the TaskManager so we can deliver it to the client. Be careful in
		 * the case of authentication where the ResponseManager must contact the
		 * TaskManaget to update his infoMap (e.g update the user's info like
		 * authentication and appID).
		 */

	}

	@Override
	public void sendMessageToNetwork(String msg, String uID) {
		GlobalManagers.networkManager.sendMessageToClient(msg, uID);
	}
}