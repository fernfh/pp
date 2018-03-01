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

public class TextfieldView extends JPanel implements PollListListener {
	private PollList polls;
	private String question;
	private Map<String, AnswerSetView> answerList = new HashMap<String, AnswerSetView>();

	public TextfieldView(PollList polls, String q) throws RemoteException {
		this.polls = polls;
		question = q;
		setLayout(new GridLayout(0, 1, 5, 5));
		polls.addPollListListener(this);
		pollUpdated(q, polls.getStats(q));
	}

	public void pollUpdated(String q, PollStats p) {
		if (q != question) { return; }
		for (String a : p.answers.keySet()) {
			int count = p.answers.get(a);
			AnswerSetView asv = answerList.get(a);
			if (asv == null) {
				asv = new AnswerSetView(polls, question, a);
				asv.update(count);
				answerList.put(a, asv);
				add(asv);
				revalidate();
				repaint();
			} else {
				asv.update(count);
			}
		}
	}
	@Override
	public void pollAdded (String q) {}
	@Override
	public void pollRemoved(String q) {}
}
