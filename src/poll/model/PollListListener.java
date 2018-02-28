package poll.model;

import java.io.Serializable;

public interface PollListListener extends Serializable {
	public void pollAdded(Poll model);
	public void pollRemoved(Poll model);
}
