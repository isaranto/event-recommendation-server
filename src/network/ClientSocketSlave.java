package network;

import java.io.DataInputStream;
import java.io.IOException;

import util.ProjectVariables;

public class ClientSocketSlave extends Thread {

	private DataInputStream in;
	private ClientSocketManager clientManager;

	public ClientSocketSlave(ClientSocketManager manager, DataInputStream in) {
		this.clientManager = manager;
		this.in = in;
	}

	public void listen() {
		long last_timestamp = 0;
		while (true) {
			try {
				long time_in_seconds = System.nanoTime() / 1000000000;
				long difference = time_in_seconds - last_timestamp;
				if (difference > ProjectVariables
						.getIntValue("message_time_gamp")) {
					last_timestamp = time_in_seconds;
					String message = in.readUTF();
					clientManager.deliverMessage(message);
				} else {
					throw new IOException();
				}
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
