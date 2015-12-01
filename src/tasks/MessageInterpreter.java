package tasks;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class MessageInterpreter {

	private static final List<String> valid_actions = Arrays.asList("add",
			"get", "delete", "edit", "authentication");

	public static boolean messageIsValid(String msg) {
		try {
			Message m = new Gson().fromJson(msg, Message.class);
			if (valid_actions.contains(m.action)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean userIsAuthenticated(String uID) {
		return false;
	}
}
