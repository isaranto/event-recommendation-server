package model;

import java.util.HashMap;

public abstract class ConnectionHashMap {

	protected HashMap connections;
	protected int maximumSize;

	public void addConnection(Connection c) {
		this.connections.put(c.getUID(), c);
	}

	public boolean containsConnection(String uID) {
		return connections.containsKey(uID);
	}

	public void deleteConnection(String uID) {
		connections.remove(uID);
	}

	public int getSize() {
		return connections.size();
	}

	public boolean isFull() {
		return getSize() == maximumSize;
	}

}
