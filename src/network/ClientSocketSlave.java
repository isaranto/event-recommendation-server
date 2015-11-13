package network;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientSocketSlave extends Thread {

	private DataInputStream in;
	private ClientSocketManager clientManager;

	public ClientSocketSlave(ClientSocketManager manager, DataInputStream in) {
		this.clientManager = manager;
		this.in = in;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String message = in.readUTF();
				clientManager.deliverMessage(message);
			} catch (IOException io) {
				clientManager.deliverIOException(io);
			}
		}
	}
}
