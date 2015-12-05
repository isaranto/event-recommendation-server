package tasks;

import java.util.Arrays;
import java.util.List;

import model.Message;

public class MessageInterpreter {

	private static final List<String> valid_actions = Arrays.asList(
			"authenticate", "sign-out");

	public static boolean messageIsValid(Message m) {
		try {
			if (valid_actions.contains(m.getAction())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean messageRequiresAuth(Message m) {
		// except auth action all messages require authentication.
		try {
			return !m.getAction().equals("authenticate");
		} catch (Exception e) {
			return true;
		}
	}
}
