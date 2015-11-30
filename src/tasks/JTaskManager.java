package tasks;

import util.GlobalManagers;

import com.google.gson.Gson;

public class JTaskManager implements TaskManager {

	@Override
	public void handleMessageFromNetwork(String msg, String uID) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Message m = new Message("action-verification", true);
		sendMessageToNetwork(new Gson().toJson(m), uID);
	}

	@Override
	public void sendMessageToNetwork(String msg, String uID) {
		GlobalManagers.networkManager.sendMessageToClient(msg, uID);
	}
}
