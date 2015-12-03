package tasks;

import java.util.HashMap;

import model.ConnectionHashMap;

public class ConnectionInfoHashMap extends ConnectionHashMap {

	public ConnectionInfoHashMap(int max) {
		this.connections = new HashMap<String, ConnectionInfo>();
		this.maximumSize = max;
	}

	public ConnectionInfo get(String uID) {
		return (ConnectionInfo) connections.get(uID);
	}

}
