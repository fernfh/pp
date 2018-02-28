package poll.rmi;

import java.util.List;
import poll.model.Poll;
import poll.model.PollList;
import poll.model.PollListListener;
import poll.model.PollListImpl;

public class Service implements PollList {
	PollListImpl pollList;
	public Service () {
		pollList = new PollListImpl();
	}
	public Poll addPoll(String q) {
		return pollList.addPoll(q);
	}
	public void removePoll(String question) {
		pollList.removePoll(question);
	}
	public List<Poll> getPolls() {
		return pollList.getPolls();
	}
	public void addPollListListener(PollListListener listener) {
		pollList.addPollListListener(listener);
	}
	public void removePollListListener(PollListListener listener) {
		pollList.removePollListListener(listener);
	}
}
