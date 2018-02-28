package poll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PollModel {

	private ArrayList<String> answerOrder = new ArrayList<String>();
	private Map<String, Integer> answers = new HashMap<String, Integer>();
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
		ensureAnswer(answer);
		answers.put(answer, count);
		fireModelChanged();
	}

	private void ensureAnswer(String a) {
		if (answerOrder.indexOf(a) == -1) {
			answerOrder.add(a);
			answers.put(a, 0);
		}
	}

	public void increment(String name) {
		int cur = answers.get(name);
		answers.put(name, cur + 1);
		fireModelChanged();
	}

	public void setCount(String name, int count) {
		answers.put(name, count);
		fireModelChanged();
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
