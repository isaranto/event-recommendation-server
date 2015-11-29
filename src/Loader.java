import util.GlobalManagers;
import util.ProjectVariables;

public class Loader {

	public static void main(String args[]) {
		System.out.println("Initialising server...");
		try {
			ProjectVariables.loadProjectVars();
			GlobalManagers.initializeManagers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Server is now running...");
	}

}
