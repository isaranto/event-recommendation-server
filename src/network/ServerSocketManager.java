package network;

import java.io.IOException;

public interface ServerSocketManager {

	public void closeSocket() throws IOException;

	public void listen() throws IOException;

	public void openSocket() throws IOException;

}
