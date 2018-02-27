package poll.model;

import java.util.ArrayList;

public class PollModel {

	private ArrayList<Answers> answers = new ArrayList<Answers>();
	private ArrayList<PollModelListener> listener = new ArrayList<PollModelListener>();
	private String question;

	public PollModel(String question) {
		this.question = question;
	}
	
	public String getQuestion () {
		return question;
	}

	public void addAnswer(String answer) {
		Answers ans = new Answers(answer);
		answers.add(ans);
	}

	public void increment(String name) {
		for (Answers answer : answers) {
			if (answer.getName().equals(name)) {
				answer.increment();
			}
		}
		fireModelChanged();
	}

	public ArrayList<Answers> getAnswers() {
		return answers;
	}

	public int sumAnswers() {
		int sum = 0;
		for (Answers answers : answers) {
			sum += answers.getCount();
		}
		return sum;
	}

	public String getPercentage(String name) {
		int count = 0;
		for (Answers answer : answers) {
			if (answer.getName().equals(name)) {
				count = answer.getCount();
			}
		}
		int denom = sumAnswers();
		if (denom == 0) {
			return "NOPE!";
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
