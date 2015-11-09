package network;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientSocketSlave extends Thread {

	DataInputStream in;
	JClientSocketManager clientManager;

	public ClientSocketSlave(JClientSocketManager manager, DataInputStream in) {
		this.clientManager = manager;
		this.in = in;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String message = in.readUTF();
				clientManager.getManager().pushMessageToTaskManager(message,
						clientManager.getUID());

			} catch (IOException io) {
				clientManager.getManager().handleClientSocketError(
						clientManager.getUID());
			}
		}
	}
}
