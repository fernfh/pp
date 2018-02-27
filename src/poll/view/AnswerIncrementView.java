package poll.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import poll.controllers.IncrementController;
import poll.model.Answers;
import poll.model.PollModel;

public class AnswerIncrementView extends JPanel {
	private Answers answer;
	private JLabel label;
	private PollModel model;

	public AnswerIncrementView(PollModel model, Answers ans) {
		this.answer = ans;
		this.model = model;
		this.label = new JLabel(answer.getName());
		this.label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(currentText());
		JButton button = new JButton("Erh�hen");
		button.setName(answer.getName());
		button.addActionListener(new IncrementController(model));

		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(button);
	}

	public void myDataWasUpdated() {
		label.setText(currentText());
	}

	private String currentText() {
		return answer.getName() + ": " + answer.getCount() + " von " + model.sumAnswers() + " ("
				+ model.getPercentage(answer.getName()) + ")";
	}
}
