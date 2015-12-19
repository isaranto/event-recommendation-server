package tasks;

import model.UpperLayerManager;

public interface TaskManager extends UpperLayerManager {

	public void sendMessageToNetwork(String msg, String uID);

	public void updateInfoMap(String uID, ConnectionInfo con);
}
