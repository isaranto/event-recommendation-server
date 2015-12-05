package util;

import db.DbManager;
import db.JDbManager;
import network.JNetworkManager;
import network.NetworkManager;
import tasks.JTaskManager;
import tasks.TaskManager;

public class GlobalManagers {

	public static NetworkManager networkManager;
	public static TaskManager taskManager;
	public static DbManager dbManager;

	public static void initializeManagers() {
		GlobalManagers.networkManager = new JNetworkManager();
		GlobalManagers.taskManager = new JTaskManager();
		GlobalManagers.dbManager = new JDbManager();
	}
}
