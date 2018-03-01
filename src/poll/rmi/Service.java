package poll.rmi;

import java.util.List;
import poll.model.PollStats;
import poll.model.PollList;
import poll.model.PollListListener;
import poll.model.PollListImpl;

public class Service implements PollList {
	PollListImpl polls;
	public Service () {
		polls = new PollListImpl();
	}
	public void addPoll(String q) {
		polls.addPoll(q);
	}
	public void removePoll(String question) {
		polls.removePoll(question);
	}
	public List<String> getPolls() {
		return polls.getPolls();
	}
	public void addPollAnswer(String q, String a) {
		polls.addPollAnswer(q, a);
	}
	public void setPollAnswer(String q, String a, int c) {
		polls.setPollAnswer(q, a, c);
	}
	public void increment(String q, String a) {
		polls.increment(q, a);
	}
	public PollStats getStats(String q) {
		return polls.getStats(q);
	}
	public void addPollListListener(PollListListener listener) {
		polls.addPollListListener(listener);
	}
	public void removePollListListener(PollListListener listener) {
		polls.removePollListListener(listener);
	}
}
