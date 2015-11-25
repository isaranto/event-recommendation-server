package network;

import java.util.HashMap;

public class ClientSocketHashMap {
	private HashMap<String, JClientSocketManager> connections;
	private int maximumSize;

	public ClientSocketHashMap(int max) {
		this.connections = new HashMap<String, JClientSocketManager>();
		this.maximumSize = max;
	}

	public void addConnection(JClientSocketManager manager) {
		this.connections.put(manager.getUID(), manager);
	}

	public boolean containsConnection(String uid) {
		return connections.containsKey(uid);
	}

	public JClientSocketManager getConnection(String uid)
			throws NullPointerException {
		return this.connections.get(uid);
	}

	public int getSize() {
		return this.connections.size();
	}

	public boolean isFull() {
		return connections.size() >= maximumSize;
	}

	public void removeConnection(String uid) {
		this.connections.remove(uid);
	}

}
