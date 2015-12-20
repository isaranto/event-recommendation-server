package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdminCommandManager {

	public static void initComponentManagers() {
		GlobalManagers.initializeManagers();
		print("Component managers initialised successfully.");
	}

	public static void loadProjectParameters() {
		try {
			GlobalManagers.initializeVariables();
			print("Project variables loaded successfully");
		} catch (Exception e) {
			print("Error loading project variables: " + e.getMessage());
		}
	}

	public static void openCommandManager() {
		printGeneric();
		while (true) {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				switch (Integer.parseInt(br.readLine())) {
				case 0:
					printHelpMenu();
					break;
				case 1:
					loadProjectParameters();
					break;
				case 2:
					initComponentManagers();
					break;
				case 3:
					terminateServer();
					break;
				default:
					printGeneric();
					break;
				}

			} catch (Exception e) {
			}
		}
	}

	public static void print(Object o) {
		System.out.println(o);
	}

	public static void printGeneric() {
		print("Press [1-3] for admin actions or 0 for help menu.");
	}

	public static void printHelpMenu() {
		print("Press 1-9 to select one of the following actions: " + "\n"
				+ "1. Load project parameters." + "\n"
				+ "2. Initialize component managers." + "\n"
				+ "3. Shut down server.");
	}

	public static void terminateServer() {
		/*
		 * TODO: Save progress, log everything.
		 */
		print("Shutting down system.");
		System.exit(0);
	}
}
