package util;

import network.JNetworkManager;
import network.NetworkManager;
import tasks.JTaskManager;
import tasks.TaskManager;

public class GlobalManagers {

	public static NetworkManager clientNetworkManager;
	public static NetworkManager mrNetworkManager;
	public static TaskManager taskManager;

	public static void initializeManagers() {
		GlobalManagers.taskManager = new JTaskManager();
		GlobalManagers.clientNetworkManager = new JNetworkManager(
				GlobalManagers.taskManager);
		GlobalManagers.mrNetworkManager = new JNetworkManager(null);

	}
}
