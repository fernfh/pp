package poll.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import poll.model.PollList;
import poll.model.PollStats;
import poll.model.PollListListener;

public class BarView extends JPanel implements PollListListener {
	private PollList polls;
	private String question;
	private Map<String, AnswerBarView> myViews = new HashMap<String, AnswerBarView>();

	public BarView(PollList polls, String q) throws RemoteException {
		this.polls = polls;
		question = q;
		polls.addPollListListener(this);
		setLayout(new GridLayout(0, 1, 1, 1));
		pollUpdated(q, polls.getStats(q));
	}

	@Override
	public void pollUpdated (String q, PollStats stats) {
		if (q != question) { return; }
		for (String answer : stats.answers.keySet()) {
			int count = stats.answers.get(answer);
			AnswerBarView view = myViews.get(answer);
			if (view == null) {
				view = new AnswerBarView(answer, stats);
				myViews.put(answer, view);
				add(view);
				revalidate();
				repaint();
			} else {
				view.update(stats);
			}
		}
	}
	@Override
	public void pollRemoved(String q) {}
	@Override
	public void pollAdded(String q) {}
}
