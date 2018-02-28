package poll.model;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PollList extends Remote {
    public Poll addPoll(String question) throws RemoteException;
    public void removePoll(String question) throws RemoteException;
    public List<Poll> getPolls() throws RemoteException;
    public void addPollListListener(PollListListener listener) throws RemoteException;
    public void removePollListListener(PollListListener listener) throws RemoteException;
}
