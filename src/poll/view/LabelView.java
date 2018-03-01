package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import poll.model.PollList;
import poll.model.PollStats;
import poll.model.PollListListener;

public class LabelView extends JPanel implements PollListListener {
	private PollList polls;
	private String question;
	private Map<String, AnswerIncrementView> myViews;

	public LabelView(PollList polls, String q) throws RemoteException {
		this.polls = polls;
		question = q;
		myViews = new HashMap<String, AnswerIncrementView>();
		setLayout(new GridLayout(0, 1, 5, 5));
		polls.addPollListListener(this);
		pollUpdated(q, polls.getStats(q));
	}

	@Override
	public void pollUpdated (String q, PollStats stats) {
		if (q != question) { return; }
		for (String ans : stats.answers.keySet()){
			int count = stats.answers.get(ans);
			AnswerIncrementView aiv = myViews.get(ans);
			if (aiv == null) {
				aiv = new AnswerIncrementView(polls, question, ans);
				myViews.put(ans, aiv);
				add(aiv);
				revalidate();
				repaint();
			} else {
				aiv.pollUpdated(q, stats);
			}
		}
	}
	@Override
	public void pollAdded (String q) {}
	@Override
	public void pollRemoved(String q) {}
}
