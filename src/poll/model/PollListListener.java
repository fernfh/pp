package poll.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PollListListener extends Remote {
	public void pollAdded(String q) throws RemoteException;
	public void pollRemoved(String q) throws RemoteException;
	public void pollUpdated(String q, PollStats stats) throws RemoteException;
}
