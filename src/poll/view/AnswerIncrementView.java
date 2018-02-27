package poll.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		label.setText(currentText());
		JButton button = new JButton("Erhöhen");
		button.setName(answer.getName());
		add(label);
		add(button);
	}

	public void myDataWasUpdated() {
		label.setText(currentText());
	}

	private String currentText() {
		return answer.getName() + ": " + answer.getCount() + " von " + model.sumAnswers() + "("
				+ model.getPercentage(answer.getName()) + ")";
	}
}
