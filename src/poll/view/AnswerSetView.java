package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import poll.model.Answers;
import poll.model.PollModel;

public class AnswerSetView extends JPanel {
	private Answers answer;
	private PollModel model;
	private JTextField textField;

	public AnswerSetView(PollModel model, Answers ans, ActionListener controller) {
		this.answer = ans;
		this.model = model;
		JLabel label = new JLabel(answer.getName());
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(answer.getName());
		textField = new JTextField();
		textField.setName(answer.getName());
		textField.addActionListener(controller);
		myDataWasUpdated();

		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(textField);
	}

	public void myDataWasUpdated() {
		textField.setText("" + answer.getCount());
	}
}
