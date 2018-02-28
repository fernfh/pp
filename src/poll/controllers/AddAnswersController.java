package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JTextField;

import poll.model.Poll;

public class AddAnswersController implements ActionListener {

	private Poll model;

	public AddAnswersController(Poll pollModel) {
		model = pollModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField) e.getSource();
		try {
			model.addAnswer(textField.getText());
		} catch (RemoteException re) {
			re.printStackTrace();
		}
	}
}
