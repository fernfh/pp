package poll.model;

import java.util.ArrayList;

public class PollModel {

	private ArrayList<Answers> answers = new ArrayList<Answers>();
	private ArrayList<PollModelListener> listener = new ArrayList<PollModelListener>();

	public PollModel() {
		Answers wasser = new Answers("Wasser");
		Answers kaffee = new Answers("Kaffee");
		Answers tee = new Answers("Tee");
		Answers pils = new Answers("Pils");
		Answers weizen = new Answers("Weizen");
		Answers weiﬂwein = new Answers("Weiﬂwein");
		Answers rotwein = new Answers("Rotwein");
		Answers rose = new Answers("RosÈ");
		answers.add(wasser);
		answers.add(kaffee);
		answers.add(tee);
		answers.add(pils);
		answers.add(weizen);
		answers.add(weiﬂwein);
		answers.add(rotwein);
		answers.add(rose);
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
