package network;

import java.io.IOException;
import java.net.Socket;

import util.GlobalManagers;
import util.GlobalVariables;

public class JNetworkManager implements NetworkManager {

	private ServerSocketManager serverSocketManager;
	private final ClientSocketHashMap clientMap;

	public JNetworkManager() {
		setUpServerSocketManager();
		clientMap = new ClientSocketHashMap(
				GlobalVariables.maximumConnectionsNum);
	}

	@Override
	public void addConnection(Socket newConnection) {
		if (clientMap.isFull()) {
			try {
				newConnection.close();
				/*
				 * TODO: log connection attempt failure due to maximum capacity
				 * of connections.
				 */
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JClientSocketManager newClient = new JClientSocketManager(
					newConnection, this);
			clientMap.addConnection(newClient);
		}
	}

	@Override
	public void handleClientSocketError(String uID) {
		/*
		 * TODO: Handles a client error. For example: close client connection,
		 * remove from data structure, warn the task manager to log him off.
		 */

	}

	@Override
	public void handleServerSocketError() {
		/*
		 * TODO: Handles a server socket error. Crucial failure, propagate
		 * message to administrator and log the error.
		 */

	}

	@Override
	public void pushMessageToTaskManager(String msg, String uID) {
		GlobalManagers.taskManager.handleMessageFromNetwork(msg, uID);
	}

	@Override
	public void sendMessageToClient(String msg, String uID) {
		try {
			if (clientMap.containsConnection(uID)) {
				JClientSocketManager target = clientMap.getConnection(uID);
				target.sendMessageToClient(msg);
			}
		} catch (IOException io) {
			io.printStackTrace();
			handleClientSocketError(uID);
		}
	}

	@Override
	public void setUpServerSocketManager() {
		serverSocketManager = new JServerSocketManager(this,
				GlobalVariables.serverPortNumber);
		try {
			serverSocketManager.openSocket();
			((Thread) serverSocketManager).start();
		} catch (IOException e) {
			handleServerSocketError();
			e.printStackTrace();
		}
	}

}
