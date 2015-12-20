package network.classes;

import java.io.IOException;
import java.net.Socket;

import network.interfaces.NetworkManager;
import network.interfaces.ServerSocketManager;

import model.UpperLayerManager;
import util.AdminCommandManager;
import util.GlobalManagers;

public class JNetworkManager implements NetworkManager {

	private ServerSocketManager serverSocketManager;
	private final ClientSocketHashMap clientMap;
	private UpperLayerManager manager;
	private int serverPort;

	public JNetworkManager(UpperLayerManager manager, int serverPort) {
		this.serverPort = serverPort;
		setUpServerSocketManager();
		clientMap = new ClientSocketHashMap(
				GlobalManagers.projectVariables.maxNumOfConnections);
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
					this.serverPort);
			serverSocketManager.openSocket();
			((Thread) serverSocketManager).start();
		} catch (Exception e) {
			handleServerSocketError(e.toString());
		}
	}

}
