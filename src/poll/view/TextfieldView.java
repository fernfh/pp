package poll.view;

import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.PollStats;

@SuppressWarnings("serial")
public class TextfieldView extends JPanel implements GuiListener {
	private RMIClient polls;
	private String question;
	private Map<String, AnswerSetView> answerList = new HashMap<String, AnswerSetView>();

	public TextfieldView(RMIClient polls2, String q) throws RemoteException {
		this.polls = polls2;
		question = q;
		setLayout(new GridLayout(0, 1, 5, 5));
		polls2.addListener(this);
		pollUpdated(q, polls2.getStats(q));
	}

	public void pollUpdated(String q, PollStats p) {
		if (!q.equals(question)) {
			return;
		}
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
	public void pollAdded(String q) {
	}

	@Override
	public void pollRemoved(String q) {
	}
}
