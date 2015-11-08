package network;

import java.net.Socket;

public interface NetworkManager {

	public void addConnection(Socket newConnection);

	public void getMessageFromTaskManager(String msg, String uID);

	public void handleClientSocketError();

	public void handleServerSocketError();

	public void pushMessageToTaskManager(String msg, String uID);

}
