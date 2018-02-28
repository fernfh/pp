package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import poll.model.Poll;

public class SetController implements ActionListener {
	private Poll model;

	public SetController(Poll pollModel) {
		model = pollModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JTextField textField = (JTextField) e.getSource();
			String name = textField.getName();
			int count = Integer.parseInt(textField.getText(), 10);
			model.setCount(name, count);
		} catch (NumberFormatException errorThatImGoingToIgnore) {
		}
	}
}
