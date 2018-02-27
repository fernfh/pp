package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poll.model.PollModel;

public class AnswerAddView extends JPanel {
	public AnswerAddView(PollModel model, ActionListener controller) {
		setLayout(new GridLayout(1, 2, 5, 5));
		JLabel label = new JLabel("Zusätzliche Antwortmöglichkeit: ");
		add(label);
		JTextField textField = new JTextField();
		textField.addActionListener(controller);
		add(textField);
	}
}
