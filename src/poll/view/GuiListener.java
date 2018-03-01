package poll.view;

import poll.model.PollStats;

public interface GuiListener {

	public void pollAdded(String q);

	public void pollRemoved(String q);

	public void pollUpdated(String q, PollStats stats);
}
