package poll.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class PollListImpl extends UnicastRemoteObject implements PollList {
	private Map<String, Poll> polls = new HashMap<String, Poll>();
	private ArrayList<PollListListener> observers = new ArrayList<PollListListener>();

	public PollListImpl() throws RemoteException {
		super();
	}

	public void addPoll(String question) {
		ensurePoll(question);
	}

	private Poll ensurePoll(String question) {
		Poll poll = polls.get(question);
		if (poll != null) {
			System.err.println("Existing Poll: " + question);
			return poll;
		}
		poll = new Poll(question);
		polls.put(question, poll);
		System.err.println("Creatd Poll, notifying " + observers.size() + " observers");
		Iterator<PollListListener> iter = observers.iterator();
		while (iter.hasNext()) {
			PollListListener l = iter.next();
			try {
				l.pollAdded(question);
			} catch (RemoteException e) {
				iter.remove();
			}
		}
		return poll;
	}

	public void removePoll(String question) {
		Poll poll = polls.get(question);
		if (poll != null) {
			polls.remove(question);
			System.err.println("Removing Poll, notifying " + observers.size() + " observers");
			Iterator<PollListListener> iter = observers.iterator();
			while (iter.hasNext()) {
				PollListListener l = iter.next();
				try {
					l.pollRemoved(question);
				} catch (RemoteException e) {
					iter.remove();
				}
			}
		}
	}

	public List<String> getPolls() {
		List<String> ret = new ArrayList<String>();
		for (String s : polls.keySet()) {
			ret.add(s);
		}
		return ret;
	}

	public void addPollAnswer(String q, String a) {
		Poll poll = ensurePoll(q);
		boolean isNew = poll.addAnswer(a);
		if (isNew) {
			PollStats stats = poll.getStats();
			System.err.println("AddPollAnswer, notifying " + observers.size() + " observers");
			Iterator<PollListListener> iter = observers.iterator();
			while (iter.hasNext()) {
				PollListListener l = iter.next();
				try {
					l.pollUpdated(q, stats);
				} catch (RemoteException e) {
					iter.remove();
				}
			}
		}
	}

	public void setPollAnswer(String q, String a, int count) {
		Poll poll = ensurePoll(q);
		boolean isChanged = poll.addAnswer(a, count);
		if (isChanged) {
			PollStats stats = poll.getStats();
			System.err.println("setPollAnswer, notifying " + observers.size() + " observers");
			Iterator<PollListListener> iter = observers.iterator();
			while (iter.hasNext()) {
				PollListListener l = iter.next();
				try {
					l.pollUpdated(q, stats);
				} catch (RemoteException e) {
					iter.remove();
				}
			}
		}
	}

	public void increment(String q, String a) {
		Poll poll = ensurePoll(q);
		poll.setCount(a, poll.getCount(a) + 1);
		PollStats stats = poll.getStats();
		System.err.println("increment, notifying " + observers.size() + " observers");
		Iterator<PollListListener> iter = observers.iterator();
		while (iter.hasNext()) {
			PollListListener l = iter.next();
			try {
				l.pollUpdated(q, stats);
			} catch (RemoteException e) {
				iter.remove();
			}
		}
	}

	public PollStats getStats(String q) {
		Poll poll = ensurePoll(q);
		return poll.getStats();
	}

	public void addPollListListener(PollListListener listener) {
		observers.add(listener);
	}

	public void removePollListListener(PollListListener listener) {
		observers.remove(listener);
	}

}
