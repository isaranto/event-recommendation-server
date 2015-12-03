package tasks;

import model.Connection;

public class ConnectionInfo extends Connection {

	private Integer appUID;
	private boolean authenticated;

	public ConnectionInfo(String networkUID) {
		this.uID = networkUID;
		this.authenticated = false;
	}

	public ConnectionInfo(String networkUID, Integer appUID,
			boolean authenticated) {
		this.uID = networkUID;
		this.appUID = appUID;
		this.authenticated = authenticated;
	}

	public Integer getAppUID() {
		return this.appUID;
	}

	public boolean isAuthenticated() {
		return this.authenticated;
	}

	public void setAppUID(Integer id) {
		this.appUID = id;
	}

	public void setAuthenticated(boolean auth) {
		this.authenticated = auth;
	}
}
