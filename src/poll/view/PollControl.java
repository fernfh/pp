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
		try {
			JLabel pollLabel = new JLabel(model.getQuestion());
			showButton = new JButton("Anzeigen");
			removeButton = new JButton("Löschen");
			add(pollLabel);
			add(showButton);
			add(removeButton);
			showButton.addActionListener(this);
			removeButton.addActionListener(this);
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}
	public void actionPerformed(ActionEvent e) {
		try {
			JButton src = (JButton) e.getSource();
			if (src == showButton) {
				new PollFrame(model, model.getQuestion());
			}
			else {
				polls.removePoll(model.getQuestion());
			}
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}
}
