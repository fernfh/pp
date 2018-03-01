package poll.model;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PollList extends Remote {
    public void addPollListListener(PollListListener listener) throws RemoteException;
    public void removePollListListener(PollListListener listener) throws RemoteException;
    public void addPoll(String q) throws RemoteException;
    public void removePoll(String q) throws RemoteException;
    public List<String> getPolls() throws RemoteException;
	public void addPollAnswer(String q, String a) throws RemoteException;
	public void setPollAnswer(String q, String a, int c) throws RemoteException;
	public void increment(String q, String a) throws RemoteException;
	public PollStats getStats(String q) throws RemoteException;
}
