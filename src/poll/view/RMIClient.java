package poll.view;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import poll.model.PollList;
import poll.model.PollListListener;
import poll.model.PollStats;

public class RMIClient implements PollListListener {

	ArrayList<GuiListener> observers = new ArrayList<GuiListener>();
	private PollList polls;

	public RMIClient(PollList polls) {
		this.polls = polls;
	}

	public void addListener(GuiListener listener) {
		observers.add(listener);
	}

	public void removeListener(GuiListener listener) {
		observers.remove(listener);
	}

	public List<String> getPolls() throws RemoteException {
		return polls.getPolls();
	}

	public PollStats getStats(String q) throws RemoteException {
		return polls.getStats(q);
	}

	@Override
	public void pollAdded(String q) {
		System.err.println("Poll Added: " + q + ", notifying " + observers.size() + " observers");
		for (GuiListener ob : observers) {
			ob.pollAdded(q);
		}
	}

	@Override
	public void pollRemoved(String q) {
		System.err.println("Poll Removed: " + q + ", notifying " + observers.size() + " observers");
		for (GuiListener ob : observers) {
			ob.pollRemoved(q);
		}
	}

	@Override
	public void pollUpdated(String q, PollStats stats) {
		System.err.println("Poll Updated: " + q + ", notifying " + observers.size() + " observers");
		System.err.println(stats.toString());
		for (GuiListener ob : observers) {
			ob.pollUpdated(q, stats);
		}
	}

	public void addPollAnswer(String question, String text) throws RemoteException {
		polls.addPollAnswer(question, text);
	}

	public void increment(String question, String answer) throws RemoteException {
		polls.increment(question, answer);
	}

	public void removePoll(String question) throws RemoteException {
		polls.removePoll(question);

	}

	public void setPollAnswer(String question, String answer, int count) throws RemoteException {
		polls.setPollAnswer(question, answer, count);
	}

	public void addPoll(String text) throws RemoteException {
		polls.addPoll(text);
	}
}
