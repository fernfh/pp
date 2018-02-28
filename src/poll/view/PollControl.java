package poll.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.init.PollFrame;
import poll.model.Poll;
import poll.model.PollList;

public class PollControl extends JPanel {
	public PollControl(PollList polls, Poll model) {

		JLabel pollLabel = new JLabel(model.getQuestion());
		JButton showButton = new JButton("Anzeigen");
		JButton removeButton = new JButton("Löschen");
		add(pollLabel);
		add(showButton);
		add(removeButton);

		showButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PollFrame(model, model.getQuestion());
			}
		});
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				polls.removePoll(model.getQuestion());
			}
		});
	}
}
