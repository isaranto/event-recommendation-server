package tasks;

import util.GlobalManagers;

public class JTaskManager implements TaskManager {

	@Override
	public void handleMessageFromNetwork(String msg, String uID) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendMessageToNetwork("Hi friend", uID);
	}

	@Override
	public void sendMessageToNetwork(String msg, String uID) {
		GlobalManagers.networkManager.sendMessageToClient(msg, uID);
	}
}
