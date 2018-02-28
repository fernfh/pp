package poll.model;

import java.io.Serializable;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

public interface Poll extends Remote {
	public String getQuestion() throws RemoteException;
	public void addAnswer(String answer) throws RemoteException;
	public void addAnswer(String answer, int count) throws RemoteException;
	public void increment(String name) throws RemoteException;
	public void setCount(String name, int count) throws RemoteException;
	public int getCount(String name) throws RemoteException;
	public int getMaxCount() throws RemoteException;
	public List<String> getAnswers() throws RemoteException;
	public int sumAnswers() throws RemoteException;
	public int getPercentage(String name) throws RemoteException;
	public void addPollModelListener(PollListener l) throws RemoteException;
	public void removePollModelListener(PollListener l) throws RemoteException;
}
