package schedulers;

import model.Message;

public class GenericQueryScheduler {

	public static void handleGenericMessage(Message m, String uID) {
		if (m.getAction().equals("authenticate")) {
			AuthQueryScheduler.handleAuthentication(m, uID);
		}
	}
}
