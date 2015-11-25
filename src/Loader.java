import util.GlobalManagers;

public class Loader {

	public static void main(String args[]) {
		System.out.println("Initialising server...");
		GlobalManagers.initializeManagers();
		System.out.println("Server is now running...");
	}

}
