package network;

import java.util.HashMap;

public class ClientSocketHashMap {
	private HashMap<String, JClientSocketManager> connections;

	public ClientSocketHashMap() {
		this.connections = new HashMap<String, JClientSocketManager>();

	}

	public void addConnection(JClientSocketManager manager) {
		this.connections.put(manager.getUID(), manager);
	}

	// what if connection is not found
	public JClientSocketManager getConnection(String uid) {
		return this.connections.get(uid);
	}

	public void removeConnection(String uid) {
		this.connections.remove(uid);

	}

}