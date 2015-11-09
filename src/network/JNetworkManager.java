package network;

import java.io.IOException;
import java.net.Socket;

import util.GlobalVariables;

public class JNetworkManager implements NetworkManager {

	private JServerSocketManager serverSocketManager;
	private final ClientSocketHashMap clientMap;

	public JNetworkManager() {
		setUpServerSocketManager();
		clientMap = new ClientSocketHashMap();
	}

	@Override
	public void addConnection(Socket newConnection) {
		JClientSocketManager newClient = new JClientSocketManager(
				newConnection, this);
		clientMap.addConnection(newClient);
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
	public void sendMessageToClient(String msg, String uID) {
		try {
			JClientSocketManager target = clientMap.getConnection(uID);
			target.sendMessageToClient(msg);
		} catch (NullPointerException n) {
			n.printStackTrace();
			/*
			 * TODO: ignore it. It can happen if when a job for a client is
			 * completed but in the meantime the connection is lost. Should not
			 * be an error as in unstable local networks it can happen many
			 * times. Log it as a warning.
			 */
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
			serverSocketManager.start();
		} catch (IOException e) {
			handleServerSocketError();
			e.printStackTrace();
		}
	}

}
