package poll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Poll {
	private ArrayList<String> answerOrder = new ArrayList<String>();
	private Map<String, Integer> answers = new HashMap<String, Integer>();
	private String question;

	Poll(String question) {
		this.question = question;
	}

	public PollStats getStats() {
		PollStats ps = new PollStats();
		for (String a : answerOrder) {
			int count = answers.get(a);
			ps.total += count;
			if (count > ps.max) {
				ps.max = count;
			}
			ps.answers.put(a, count);
		}
		return ps;
	}

	public String getQuestion() {
		return question;
	}

	public boolean addAnswer(String answer) {
		return ensureAnswer(answer);
	}

	public boolean addAnswer(String answer, int count) {
		boolean isNew = ensureAnswer(answer);
		int wasCount = answers.get(answer);
		answers.put(answer, count);
		return isNew || wasCount == count;
	}

	private boolean ensureAnswer(String a) {
		if (answerOrder.indexOf(a) != -1) {
			return false;
		}
		answerOrder.add(a);
		answers.put(a, 0);
		return true;
	}

	public void increment(String name) {
		int cur = answers.get(name);
		answers.put(name, cur + 1);
	}

	public void setCount(String name, int count) {
		answers.put(name, count);
	}

	public int getCount(String name) {
		return answers.get(name);
	}

	public int getMaxCount() {
		int count = 0;
		for (Entry<String, Integer> entry : answers.entrySet()) {
			int entryCount = entry.getValue();
			if (entryCount > count) {
				count = entryCount;
			}
		}
		return count;
	}

	public ArrayList<String> getAnswers() {
		return new ArrayList<String>(answerOrder);
	}

	public int sumAnswers() {
		int sum = 0;
		for (Entry<String, Integer> entry : answers.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}

	public int getPercentage(String name) {
		int count = answers.get(name);
		int denom = sumAnswers();
		if (denom == 0) {
			return 0;
		}
		int percentage = (100 * count) / denom;
		return percentage;
	}
}
