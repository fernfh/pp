package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import poll.view.RMIClient;

public class IncrementController implements ActionListener {
	private RMIClient polls;
	private String question;
	private String answer;

	public IncrementController(RMIClient polls, String q, String a) {
		this.polls = polls;
		question = q;
		answer = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			polls.increment(question, answer);
		} catch (RemoteException re) {
		}
	}
}
