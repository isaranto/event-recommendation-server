package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class JClientSocketManager implements ClientSocketManager {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private NetworkManager manager;
	private String uid; // random uid
	private ClientSocketSlave slave;

	// Slave slave; // The thread listening for messages from client(!)

	public JClientSocketManager(Socket socket, NetworkManager manager) {
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
		this.slave = new ClientSocketSlave(this, in);
		this.slave.start();
	}

	@Override
	public void deliverIOException(IOException io) {
		this.manager.handleClientSocketError(this.uid);
	}

	@Override
	public void deliverMessage(String msg) {
		this.manager.pushMessageToTaskManager(msg, this.uid);
	}

	public String getUID() {
		return this.uid;
	}

	@Override
	public void sendMessageToClient(String msg) throws IOException {
		this.out.writeUTF(msg);
	}

	@Override
	public void terminateConnection() throws IOException {
		slave.interrupt();
		closeStreams();
		socket.close();
	}
}
