package poll.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poll.model.PollList;
import poll.controllers.AddAnswersController;

public class AnswerAddView extends JPanel {
	public AnswerAddView(PollList polls, String q) {
		setLayout(new GridLayout(1, 2, 5, 5));
		add(new JLabel("Zusätzliche Antwortmöglichkeit: "));
		JTextField textField = new JTextField();
		textField.addActionListener(new AddAnswersController(polls, q));
		add(textField);
	}
}
