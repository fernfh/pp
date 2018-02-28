package poll.model;

public interface PollListListener {
	public void pollAdded(Poll model);
	public void pollRemoved(Poll model);
}
