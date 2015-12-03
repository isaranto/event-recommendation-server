package tasks;

import java.util.Arrays;
import java.util.List;

import model.Message;

import com.google.gson.Gson;

public class MessageInterpreter {

	private static final List<String> valid_actions = Arrays.asList("add",
			"get", "delete", "edit", "authenticate");

	public static boolean messageIsValid(String msg) {
		try {
			Message m = new Gson().fromJson(msg, Message.class);
			if (valid_actions.contains(m.getAction())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean messageRequiresAuth(String msg) {
		// except auth action all messages require authentication.
		try {
			Message m = new Gson().fromJson(msg, Message.class);
			return !m.getAction().equals("authentication");
		} catch (Exception e) {
			return true;
		}
	}
}
