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

	public void listen() {
		while (true) {
			try {
				String message = in.readUTF();
				clientManager.deliverMessage(message);
			} catch (IOException io) {
				clientManager.deliverIOException(io);
				break;
			}
		}
	}

	@Override
	public void run() {
		listen();
	}
}
