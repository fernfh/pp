package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JTextField;

import poll.model.PollList;

public class SetController implements ActionListener {
	private PollList polls;
	private String question;
	private String answer;

	public SetController(PollList polls, String q, String a) {
		this.polls = polls;
		question = q;
		answer = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JTextField textField = (JTextField) e.getSource();
			int count = Integer.parseInt(textField.getText(), 10);
			polls.setPollAnswer(question, answer, count);
		} catch (NumberFormatException errorThatImGoingToIgnore) {
		} catch (RemoteException re) {}
	}
}
