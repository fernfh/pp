package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;

import poll.view.ExceptionDialog;
import poll.view.RMIClient;

public class SetController implements ActionListener {
	private RMIClient polls;
	private String question;
	private String answer;

	public SetController(RMIClient polls2, String q, String a) {
		this.polls = polls2;
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
		} catch (RemoteException re) {
			new ExceptionDialog(re);
		}
	}
}
