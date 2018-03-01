package poll.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.controllers.RemovePollController;
import poll.init.PollFrame;

@SuppressWarnings("serial")
public class PollControl extends JPanel implements ActionListener {
	JButton showButton;
	JButton removeButton;
	RMIClient polls;
	private String question;

	public PollControl(RMIClient polls, String q) {
		this.polls = polls;
		question = q;
		JLabel pollLabel = new JLabel(question);
		showButton = new JButton("Anzeigen");
		removeButton = new JButton("Löschen");
		add(pollLabel);
		add(showButton);
		add(removeButton);
		showButton.addActionListener(this);
		removeButton.addActionListener(new RemovePollController(polls, q));
	}

	public void actionPerformed(ActionEvent e) {
		try {
			new PollFrame(polls, question);
		} catch (RemoteException re) {
			new ExceptionDialog(re);
		}
	}
}
