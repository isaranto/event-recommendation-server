package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import network.classes.JNetworkManager;
import network.interfaces.NetworkManager;
import tasks.JTaskManager;
import tasks.TaskManager;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class GlobalManagers {

	public static NetworkManager clientNetworkManager;
	public static NetworkManager mrNetworkManager;
	public static TaskManager taskManager;
	public static ProjectVariables projectVariables;

	public static void initializeManagers() {
		GlobalManagers.taskManager = new JTaskManager();
		GlobalManagers.clientNetworkManager = new JNetworkManager(
				GlobalManagers.taskManager,
				GlobalManagers.projectVariables.clientPort);
		GlobalManagers.mrNetworkManager = new JNetworkManager(null,
				GlobalManagers.projectVariables.mrPort);

	}

	public static void initializeVariables() {
		try {
			projectVariables = new Gson().fromJson(new BufferedReader(
					new FileReader(ProjectVariables.filepath)),
					ProjectVariables.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
