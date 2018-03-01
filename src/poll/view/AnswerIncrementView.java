package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import poll.model.PollList;
import poll.model.PollStats;
import poll.model.PollListListener;
import poll.controllers.IncrementController;

public class AnswerIncrementView extends JPanel implements PollListListener {
	private String answer;
	private String question;
	private JLabel label;
	private PollList polls;

	public AnswerIncrementView(PollList polls, String q, String a) {
		this.polls = polls;
		question = q;
		answer = a;
		label = new JLabel(answer);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		JButton button = new JButton("Erhöhen");
		button.setName(answer);
		button.addActionListener(new IncrementController(polls, q, a));
		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(button);
	}

	@Override
	public void pollUpdated (String q, PollStats stats) {
		if (q != question) { return; }
		int count = stats.answers.get(answer);
		int total = stats.total;
		int percentage = total == 0 ? 0 : (100 * count) / total;
		label.setText(answer + ": " + count + " von " + stats.total + " (" + percentage + "%)");
	}
	@Override
	public void pollAdded (String q) {}
	@Override
	public void pollRemoved(String q) {}
}
