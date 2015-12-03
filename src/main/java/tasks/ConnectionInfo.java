package tasks;

import model.Connection;

public class ConnectionInfo extends Connection {

	private String appUID;
	private boolean authenticated;

	public ConnectionInfo(String networkUID) {
		this.uID = networkUID;
		this.authenticated = false;
	}

	public String getAppUID() {
		return this.appUID;
	}

	public boolean isAuthenticated() {
		return this.authenticated;
	}

	public void setAppUID(String id) {
		this.appUID = id;
	}

	public void setAuthenticated(boolean auth) {
		this.authenticated = auth;
	}
}
