package util;

import network.JNetworkManager;
import network.NetworkManager;
import tasks.JTaskManager;
import tasks.TaskManager;

public class GlobalManagers {

	public static NetworkManager networkManager;
	public static TaskManager taskManager;

	public static void initializeManagers() {
		GlobalManagers.networkManager = new JNetworkManager();
		GlobalManagers.taskManager = new JTaskManager();
	}
}
