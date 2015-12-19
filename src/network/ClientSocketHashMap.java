package network;

import java.util.HashMap;

import model.ConnectionHashMap;

public class ClientSocketHashMap extends ConnectionHashMap {

	public ClientSocketHashMap(int max) {
		this.connections = new HashMap<String, JClientSocketManager>();
		this.maximumSize = max;
	}

	public JClientSocketManager getConnection(String uid)
			throws NullPointerException {
		return (JClientSocketManager) this.connections.get(uid);
	}

	public void removeConnection(String uid) {
		this.connections.remove(uid);
	}

}
