package network;

import java.io.IOException;
import java.net.Socket;

import model.UpperLayerManager;
import util.AdminCommandManager;
import util.ProjectVariables;

public class JNetworkManager implements NetworkManager {

	private ServerSocketManager serverSocketManager;
	private final ClientSocketHashMap clientMap;
	private UpperLayerManager manager;

	public JNetworkManager(UpperLayerManager manager) {
		setUpServerSocketManager();
		clientMap = new ClientSocketHashMap(
				ProjectVariables.getIntValue("max_num_of_connections"));
		this.manager = manager;
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
			try {
				newClient.createStreams();
				clientMap.addConnection(newClient);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handleClientSocketError(String uID) {
		try {
			clientMap.getConnection(uID).terminateConnection();
			clientMap.removeConnection(uID);
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * TODO: log exception;
			 */
		}
	}

	@Override
	public void handleServerSocketError(String e) {
		AdminCommandManager.print("Detected error in server socket: " + e);
	}

	@Override
	public void pushMessageToTaskManager(String msg, String uID) {
		manager.handleMessageFromNetwork(msg, uID);
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
		try {

			serverSocketManager = new JServerSocketManager(this,
					ProjectVariables.getIntValue("server_port"));
			serverSocketManager.openSocket();
			((Thread) serverSocketManager).start();
		} catch (Exception e) {
			handleServerSocketError(e.toString());
		}
	}

}
