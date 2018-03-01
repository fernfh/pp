package poll.view;

import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.PollStats;

@SuppressWarnings("serial")
public class LabelView extends JPanel implements GuiListener {
	private RMIClient polls;
	private String question;
	private Map<String, AnswerIncrementView> myViews;

	public LabelView(RMIClient polls, String q) throws RemoteException {
		this.polls = polls;
		question = q;
		myViews = new HashMap<String, AnswerIncrementView>();
		setLayout(new GridLayout(0, 1, 5, 5));
		polls.addListener(this);
		pollUpdated(q, polls.getStats(q));
	}

	@Override
	public void pollUpdated(String q, PollStats stats) {
		if (!q.equals(question)) {
			return;
		}
		for (String ans : stats.answers.keySet()) {
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
	public void pollAdded(String q) {
	}

	@Override
	public void pollRemoved(String q) {
	}
}
