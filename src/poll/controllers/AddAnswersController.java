package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import poll.model.PollModel;

public class AddAnswersController implements ActionListener {

	private PollModel model;

	public AddAnswersController(PollModel pollModel) {
		model = pollModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField) e.getSource();
		model.addAnswer(textField.getText());
	}
}
