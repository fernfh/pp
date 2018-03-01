package poll.view;

import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.PollStats;

@SuppressWarnings("serial")
public class BarView extends JPanel implements GuiListener {
	private String question;
	private Map<String, AnswerBarView> myViews = new HashMap<String, AnswerBarView>();

	public BarView(RMIClient polls, String q) throws RemoteException {
		question = q;
		polls.addListener(this);
		setLayout(new GridLayout(0, 1, 1, 1));
		pollUpdated(q, polls.getStats(q));
	}

	@Override
	public void pollUpdated(String q, PollStats stats) {
		if (!q.equals(question)) {
			return;
		}
		for (String answer : stats.answers.keySet()) {
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
	public void pollRemoved(String q) {
	}

	@Override
	public void pollAdded(String q) {
	}
}
