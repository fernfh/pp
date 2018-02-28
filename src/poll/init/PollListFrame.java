package poll.init;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollList;
import poll.model.PollListListener;

public class PollListFrame extends JFrame implements PollListListener {
	private JPanel pollList;

	public PollListFrame(PollList polls, String title) {
		super(title);
		pollList = new JPanel();
		add(pollList, BorderLayout.CENTER);
		pollList.setBorder(BorderFactory.createTitledBorder("Alle Umfragen"));
		JPanel newPollPane = new NewPollPane(polls);
		add(newPollPane, BorderLayout.SOUTH);
		newPollPane.setBorder(BorderFactory.createTitledBorder("Neue Umfrage anlegen"));
		setSize(600, 400);
		setLocation(200, 200);
		setVisible(true);
	}

	@Override
	public void pollAdded(Poll model) {
		new PollFrame(model, model.getQuestion());
	}

	@Override
	public void pollRemoved(Poll model) {
		// TODO Auto-generated method stub

	}
}
