package tasks;

public interface TaskManager {

	public void handleMessageFromNetwork(String msg, String uID);

	public void sendMessageToNetwork(String msg, String uID);

	public void updateInfoMap(String uID, ConnectionInfo con);
}
