package poll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollList {
	private Map<String, Poll> polls = new HashMap<String, Poll>();
	private ArrayList<PollListListener> observers = new ArrayList<PollListListener>();

	public void addPoll(Poll p) {
		polls.put(p.getQuestion(), p);
		for (PollListListener l : observers) {
			l.pollAdded(p);
		}
	}

	public void removePoll(String question) {
		Poll poll = polls.get(question);
		if (poll != null) {
			polls.remove(question);
			for (PollListListener l : observers) {
				l.pollRemoved(poll);
			}
		}
	}

	public List<Poll> getPolls() {
		List<Poll> ret = new ArrayList<Poll>();
		for (String s : polls.keySet()) {
			ret.add(polls.get(s));
		}
		return ret;
	}

	public void addPollListListener(PollListListener listener) {
		observers.add(listener);
	}

	public void removePollListListener(PollListListener listener) {
		observers.remove(listener);
	}
}
