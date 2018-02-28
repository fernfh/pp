package poll.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.init.PollFrame;
import poll.model.Poll;
import poll.model.PollList;

public class PollControl extends JPanel implements ActionListener {
	JButton showButton;
	JButton removeButton;
	Poll model;
	PollList polls;
	public PollControl(PollList polls, Poll model) {
		this.polls = polls;
		this.model = model;
		JLabel pollLabel = new JLabel(model.getQuestion());
		showButton = new JButton("Anzeigen");
		removeButton = new JButton("Löschen");
		add(pollLabel);
		add(showButton);
		add(removeButton);
		showButton.addActionListener(this);
		removeButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (src == showButton) {
			new PollFrame(model, model.getQuestion());
		}
		else {
			try {
				polls.removePoll(model.getQuestion());
			} catch (RemoteException re) {
				new RemoteExceptionView(re);
			}
		}
	}
}
