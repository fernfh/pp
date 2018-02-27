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
		if (answers.get(answer) == null) {
			Answers ans = new Answers(answer);
			answers.put(answer, ans);
			fireModelChanged();
		}
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

	public String getPercentage(String name) {
		int count = 0;
		for (Entry<String, Answers> entry : answers.entrySet()) {
			Answers answer = entry.getValue();
			if (answer.getName().equals(name)) {
				count = answer.getCount();
			}
		}
		int denom = sumAnswers();
		if (denom == 0) {
			return "N/A";
		}
		int percentage = 100 / denom * count;
		return "" + percentage + "%";
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
