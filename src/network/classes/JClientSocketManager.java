package network.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

import network.interfaces.ClientSocketManager;
import network.interfaces.ClientSocketSlave;
import network.interfaces.NetworkManager;

import model.Connection;

public class JClientSocketManager extends Connection implements
		ClientSocketManager {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private NetworkManager manager;
	private ClientSocketSlave slave;

	public JClientSocketManager(Socket socket, NetworkManager manager) {
		this.socket = socket;
		this.manager = manager;
		this.uID = UUID.randomUUID().toString();
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
		this.manager.handleClientSocketError(this.uID);
	}

	@Override
	public void deliverMessage(String msg) {
		this.manager.pushMessageToTaskManager(msg, this.uID);
	}

	@Override
	public void sendMessageToClient(String msg) throws IOException {
		this.out.writeUTF(msg);
		this.out.flush();
	}

	@Override
	public void terminateConnection() throws IOException {
		slave.interrupt();
		closeStreams();
		socket.close();
	}
}
