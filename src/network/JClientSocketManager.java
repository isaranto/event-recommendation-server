package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class JClientSocketManager implements ClientSocketManager {

	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	JNetworkManager manager;
	String uid; // random uid

	// Slave slave; // The thread listening for messages from client(!)

	public JClientSocketManager(Socket socket, JNetworkManager manager) {
		this.socket = socket;
		this.manager = manager;
		this.uid = UUID.randomUUID().toString();
	}

	@Override
	public void closeStreams() throws IOException {
		in.close();
		out.close();
	}

	@Override
	public void createStreams() throws IOException {
		this.in = new DataInputStream(socket.getInputStream());
		this.out = new DataOutputStream(socket.getOutputStream());
	}

	public JNetworkManager getManager() {
		return this.manager;
	}

	@Override
	public void sendMessageToClient(String msg) throws IOException {
		this.out.writeUTF(msg);
	}

	@Override
	public void terminateConnection() throws IOException {
		socket.close();
	}
}
