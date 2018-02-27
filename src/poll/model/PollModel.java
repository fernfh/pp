package poll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PollModel {

	private Map<String, Answers> answers = new HashMap<String, Answers>();
	private ArrayList<PollModelListener> listener = new ArrayList<PollModelListener>();
	private String question;

	public PollModel(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void addAnswer(String answer) {
		ensureAnswer(answer);
		fireModelChanged();
	}

	public void addAnswer(String answer, int count) {
		Answers a = ensureAnswer(answer);
		a.setCount(count);
		fireModelChanged();
	}

	private Answers ensureAnswer(String a) {
		Answers ans = answers.get(a);
		if (answers.get(a) == null) {
			ans = new Answers(a);
			answers.put(a, ans);
		}
		return ans;
	}

	public void increment(String name) {
		Answers ans = answers.get(name);
		if (ans != null) {
			ans.increment();
			fireModelChanged();
		}
	}

	public void setCount(String name, int count) {
		Answers ans = answers.get(name);
		if (ans != null) {
			ans.setCount(count);
			fireModelChanged();
		}
	}

	public int getMaxCount() {
		int count = 0;
		for (Entry<String, Answers> entry : answers.entrySet()) {
			int entryCount = entry.getValue().getCount();
			if (entryCount > count) {
				count = entryCount;
			}
		}
		return count;
	}

	public ArrayList<Answers> getAnswers() {
		ArrayList<Answers> currentAnswers = new ArrayList<Answers>();
		for (Entry<String, Answers> entry : answers.entrySet()) {
			currentAnswers.add(entry.getValue());
		}
		return currentAnswers;
	}

	public int sumAnswers() {
		int sum = 0;
		for (Entry<String, Answers> entry : answers.entrySet()) {
			sum += entry.getValue().getCount();
		}
		return sum;
	}

	public int getPercentage(String name) {
		Answers ans = answers.get(name);
		if (ans == null) {
			return 0;
		}
		int count = ans.getCount();
		int denom = sumAnswers();
		if (denom == 0) {
			return 0;
		}
		int percentage = (100 * count) / denom;
		return percentage;
	}

	public void addPollModelListener(PollModelListener l) {
		listener.add(l);
	}

	public void removePollModelListener(PollModelListener l) {
		listener.remove(l);
	}

	private void fireModelChanged() {
		for (PollModelListener l : listener) {
			l.valueChanged();
		}
	}
}
