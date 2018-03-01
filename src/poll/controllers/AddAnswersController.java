package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;

import poll.view.RMIClient;

public class AddAnswersController implements ActionListener {

	private RMIClient polls;
	private String question;

	public AddAnswersController(RMIClient polls, String q) {
		this.polls = polls;
		question = q;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField) e.getSource();
		try {
			polls.addPollAnswer(question, textField.getText());
		} catch (RemoteException re) {
			re.printStackTrace();
		}
	}
}
