package network.interfaces;

import java.io.IOException;

public interface ClientSocketManager {

	public void closeStreams() throws IOException;

	public void createStreams() throws IOException;

	public void deliverIOException(IOException io);

	public void deliverMessage(String msg);

	public void sendMessageToClient(String msg) throws IOException;

	public void terminateConnection() throws IOException;

}
