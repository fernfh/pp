package poll.model;

import java.io.Serializable;

public interface PollListener extends Serializable {
	public void valueChanged();
}
