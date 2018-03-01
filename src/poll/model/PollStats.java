package poll.model;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class PollStats implements Serializable {
	public Map<String, Integer> answers = new HashMap<String, Integer>();
	public int total;
	public int max;
}
