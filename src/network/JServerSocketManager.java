package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JServerSocketManager extends Thread implements ServerSocketManager {

	private ServerSocket serverSocket;
	private final int portNumber;
	private final JNetworkManager networkManager;

	public JServerSocketManager(JNetworkManager networkManager, int portNumber) {
		this.networkManager = networkManager;
		this.portNumber = portNumber;
	}

	@Override
	public void closeSocket() throws IOException {
		if (serverSocket != null) {
			serverSocket.close();
		}
	}

	@Override
	public void listen() throws IOException {
		while (true) {
			Socket newConnection = serverSocket.accept();
			networkManager.addConnection(newConnection);
		}
	}

	@Override
	public void openSocket() throws IOException {
		serverSocket = new ServerSocket(portNumber);
	}

	@Override
	public void run() {
		try {
			listen();
		} catch (IOException e) {
			e.printStackTrace();
			networkManager.handleServerSocketError();
		}

	}
}
