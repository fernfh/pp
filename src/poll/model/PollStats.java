package poll.model;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

@SuppressWarnings("serial")
public class PollStats implements Serializable {
	public Map<String, Integer> answers = new HashMap<String, Integer>();
	public int total;
	public int max;

	@Override
	public String toString() {
		String out = "";
		for (String s : answers.keySet()) {
			int count = answers.get(s);
			out += "\n  '" + s + "': " + count;
		}
		out += "\n Total: " + total + ", Max: " + max + "\n";
		return out;
	}
}
