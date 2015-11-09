package network;

import java.io.IOException;
import java.net.Socket;

import util.GlobalVariables;

public class JNetworkManager implements NetworkManager {

	private JServerSocketManager serverSocketManager;

	public JNetworkManager() {
		setUpServerSocketManager();
	}

	@Override
	public void addConnection(Socket newConnection) {
		/*
		 * TODO: get a new connection from server socket manager and add it to
		 * the client connections data structure.
		 */

	}

	@Override
	public void getMessageFromTaskManager(String msg, String uID) {
		/*
		 * TODO: get a message from task manager and send it to the right
		 * client.
		 */

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
		/*
		 * TODO: push a message from a client to the task manager.
		 */

	}

	@Override
	public void setUpServerSocketManager() {
		serverSocketManager = new JServerSocketManager(this,
				GlobalVariables.serverPortNumber);
		try {
			serverSocketManager.openSocket();
			serverSocketManager.start();
		} catch (IOException e) {
			handleServerSocketError();
			e.printStackTrace();
		}
	}

}
