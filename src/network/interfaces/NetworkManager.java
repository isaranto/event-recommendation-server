package network.interfaces;

import java.net.Socket;

public interface NetworkManager {

	public void addConnection(Socket newConnection);

	public void handleClientSocketError(String uID);

	public void handleServerSocketError(String e);

	public void pushMessageToTaskManager(String msg, String uID);

	public void sendMessageToClient(String msg, String uID);

	public void setUpServerSocketManager();

}
