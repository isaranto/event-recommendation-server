package util;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ProjectVariables {

	/*
	 * Loading project parameters from an external Json file. Please view the
	 * example Json file on the project's directory for more details.
	 */

	private static String filepath = "project_vars.json";
	private static JSONObject projectVars;

	public static int getIntValue(String key) {
		if (projectVars.get(key).getClass().getSimpleName().equals("Long")) {
			return ((Long) projectVars.get(key)).intValue();
		} else {
			return -1;
		}
	}

	public static Object getValue(String key) {
		return projectVars.get(key);
	}

	public static void loadProjectVars() throws Exception {
		projectVars = (JSONObject) new JSONParser().parse(new FileReader(
				filepath));
	}

}
